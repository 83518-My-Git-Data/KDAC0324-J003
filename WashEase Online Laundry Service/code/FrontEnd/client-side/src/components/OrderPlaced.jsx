import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const OrderPlaced = () => {
  const [orderPlaced, setOrderPlaced] = useState(false);
  const navigate = useNavigate();

  const handlePlaceOrder = () => {
    // Set orderPlaced to true to display the success message
    setOrderPlaced(true);

    // Redirect to the home page after a delay
    setTimeout(() => {
      navigate('/landing-page');
    }, 3000); // Redirect after 3 seconds
  };

  // Dummy data for order summary and address
  const orderSummary = {
    orderId: '123456',
    items: [
      { name: 'Product 1', quantity: 2, price: 10.99 },
      { name: 'Product 2', quantity: 1, price: 24.99 },
    ],
    total: 46.97,
  };

  const address = {
    buildingName: 'Sunset Villa',
    streetName: '123 Elm Street',
    area: 'Downtown',
    city: 'Metropolis',
    state: 'CA',
    country: 'USA',
    pincode: '90210',
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-blue-50">
      <div className="bg-white p-8 rounded-lg shadow-lg text-center">
        <h1 className="text-4xl font-bold text-blue-600 mb-4">Order Summary</h1>
        
        {orderPlaced ? (
          <div>
            <h2 className="text-3xl font-semibold text-green-600 mb-4">Order Placed Successfully!</h2>
            <p className="text-xl text-gray-700 mb-4">You will be redirected to the home page shortly.</p>
          </div>
        ) : (
          <>
            {/* Display order summary */}
            <div className="text-left mb-4">
              <h2 className="text-2xl font-semibold text-gray-800 mb-2">Order Summary</h2>
              <div className="bg-blue-100 p-4 rounded-md">
                <p><strong>Order ID:</strong> {orderSummary.orderId}</p>
                <p><strong>Total Amount:</strong> ${orderSummary.total.toFixed(2)}</p>
                <h3 className="text-xl font-semibold mt-4">Items:</h3>
                <ul className="list-disc pl-5">
                  {orderSummary.items.map((item, index) => (
                    <li key={index}>
                      {item.quantity} x {item.name} @ ${item.price.toFixed(2)} each
                    </li>
                  ))}
                </ul>
              </div>

              {/* Display delivery address */}
              <h2 className="text-2xl font-semibold text-gray-800 mt-4 mb-2">Delivery Address</h2>
              <div className="bg-blue-100 p-4 rounded-md">
                <p><strong>Building Name:</strong> {address.buildingName}</p>
                <p><strong>Street Name:</strong> {address.streetName}</p>
                <p><strong>Area:</strong> {address.area}</p>
                <p><strong>City:</strong> {address.city}</p>
                <p><strong>State:</strong> {address.state}</p>
                <p><strong>Country:</strong> {address.country}</p>
                <p><strong>Pincode:</strong> {address.pincode}</p>
              </div>
            </div>

            {/* Place Order Button */}
            <button
              onClick={handlePlaceOrder}
              className="mt-6 bg-blue-500 text-white px-4 py-2 rounded-lg text-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-opacity-50"
            >
              Place Order
            </button>
          </>
        )}

        <p className="text-lg text-gray-500 mt-4">
          If you are not redirected automatically, <a href="/" className="text-blue-500">click here</a>.
        </p>
      </div>
    </div>
  );
};

export default OrderPlaced;
