import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom'; // Import useNavigate for programmatic navigation

const AddToCartPage = () => {
  const [clothType, setClothType] = useState('');
  const [cartItems, setCartItems] = useState([]);
  const location = useLocation(); // Hook to get navigation state
  const navigate = useNavigate(); // Hook to navigate programmatically

  const clothOptions = ['T-Shirt', 'Shirt', 'Jacket'];

  useEffect(() => {
    if (location.state && location.state.vendorName) {
      console.log(`Navigated from vendor: ${location.state.vendorName}`);
    }
  }, [location.state]);

  const handleAddToCart = () => {
    if (clothType) {
      const newItem = {
        id: cartItems.length + 1,
        cloth: clothType,
        quantity: 1 
      };
      setCartItems([...cartItems, newItem]);
      setClothType('');
    } else {
      alert('Please select a cloth type.');
    }
  };

  const handleQuantityChange = (id, change) => {
    setCartItems(cartItems.map(item =>
      item.id === id ? { ...item, quantity: Math.max(1, item.quantity + change) } : item
    ));
  };

  const calculateTotal = () => {
    const prices = {
      'T-Shirt': 10,
      'Shirt': 20,
      'Jacket': 30
    };
    return cartItems.reduce((total, item) => total + (prices[item.cloth] * item.quantity), 0);
  };

  const handlePlaceOrder = () => {
    setCartItems([]); // Clear cart after placing the order
    navigate('/address-page'); // Navigate to the address page
  };

  return (
    <div className="min-h-screen flex flex-col bg-blue-50">
      {/* Navbar */}
      <nav className="bg-blue-300 text-white p-2 mb-2 w-full flex items-center">
        <h1 className="text-3xl font-bold">WashEase</h1>
      </nav>

      {/* Main Content */}
      <div className="flex-1 p-2 flex flex-col md:flex-row">
        {/* Left Section (80%) */}
        <div className="flex-1 md:pr-2">
          <div className="flex flex-col space-y-2">
            <div className="flex flex-col items-start"> 
              <label className="block text-base font-medium mb-1">Select Cloth Type:</label>
              <select 
                value={clothType}
                onChange={(e) => setClothType(e.target.value)}
                className="border p-1 rounded w-full md:w-48 text-left text-base"
              >
                <option value="">--Select--</option>
                {clothOptions.map((option, index) => (
                  <option key={index} value={option}>{option}</option>
                ))}
              </select>
            </div>

            <button 
              onClick={handleAddToCart}
              className="bg-blue-500 text-white px-3 py-1 rounded-md text-base hover:bg-blue-600"
            >
              Add to Cart
            </button>

            <div className="mt-2 bg-white p-2 rounded-lg shadow-lg">
              <h2 className="text-base font-semibold mb-1">Cart Items</h2>
              <table className="w-full border-collapse border border-gray-300">
                <thead>
                  <tr>
                    <th className="border border-gray-300 p-1 text-sm">Cloth Type</th>
                    <th className="border border-gray-300 p-1 text-sm">Quantity</th>
                    <th className="border border-gray-300 p-1 text-sm">Price</th>
                    <th className="border border-gray-300 p-1 text-sm">Total</th>
                  </tr>
                </thead>
                <tbody>
                  {cartItems.map(item => {
                    const price = {
                      'T-Shirt': 10,
                      'Shirt': 20,
                      'Jacket': 30
                    }[item.cloth];
                    const total = price * item.quantity;

                    return (
                      <tr key={item.id}>
                        <td className="border border-gray-300 p-1 text-sm">{item.cloth}</td>
                        <td className="border border-gray-300 p-1 text-sm">
                          <div className="flex items-center">
                            <button
                              onClick={() => handleQuantityChange(item.id, -1)}
                              className="bg-gray-200 text-gray-800 px-1 py-0.5 rounded-l-md"
                              disabled={item.quantity <= 1}
                            >
                              -
                            </button>
                            <input
                              type="number"
                              value={item.quantity}
                              readOnly
                              className="border-t border-b border-gray-300 text-center w-10 text-sm"
                            />
                            <button
                              onClick={() => handleQuantityChange(item.id, 1)}
                              className="bg-gray-200 text-gray-800 px-1 py-0.5 rounded-r-md"
                            >
                              +
                            </button>
                          </div>
                        </td>
                        <td className="border border-gray-300 p-1 text-sm">${price}</td>
                        <td className="border border-gray-300 p-1 text-sm">${total}</td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
            </div>

            <button 
              onClick={handlePlaceOrder}
              className="bg-green-500 text-white px-3 py-1 rounded-md text-base hover:bg-green-600 mt-2"
            >
              Place Order
            </button>
          </div>
        </div>

        {/* Vertical Divider */}
        <div className="w-px bg-gray-300 my-2 md:mx-2"></div>

        {/* Right Section (20%) */}
        <div className="w-full md:w-1/4 pl-2">
          <div className="bg-white p-2 rounded-lg shadow-lg">
            <h2 className="text-xl font-semibold mb-1">Order Summary</h2>
            <div className="space-y-1">
              <div className="flex justify-between text-sm">
                <span className="font-medium">Items in Cart:</span>
                <span>{cartItems.length}</span>
              </div>
              <div className="flex justify-between text-sm">
                <span className="font-medium">Total Amount:</span>
                <span className="font-bold">${calculateTotal()}</span>
              </div>
            </div>
          </div>
        </div>
      </div>

      {/* Footer */}
      <footer className="bg-sky-400 text-white text-center py-1 mt-auto">
        <p className="text-base">© 2024 WashEase. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default AddToCartPage;
