import React, { useState } from 'react';

// Dummy data for orders
const dummyOrders = [
  { id: 1, customerName: 'John Doe', item: 'Laptop', quantity: 1, status: 'Shipped' },
  { id: 2, customerName: 'Jane Smith', item: 'Smartphone', quantity: 2, status: 'Pending' },
  { id: 3, customerName: 'Alice Johnson', item: 'Headphones', quantity: 5, status: 'Delivered' }
];

// Dummy data for users
const dummyUsers = [
  { id: 1, name: 'Emily Clark', email: 'emily@example.com' },
  { id: 2, name: 'Michael Brown', email: 'michael@example.com' },
  { id: 3, name: 'Sarah Wilson', email: 'sarah@example.com' }
];

const VendorDashboard = () => {
  const [orders, setOrders] = useState(dummyOrders);
  const [users, setUsers] = useState(dummyUsers);
  const [editingOrder, setEditingOrder] = useState(null);
  const [editingUser, setEditingUser] = useState(null);

  const handleEditOrderClick = (order) => {
    setEditingOrder(order);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    if (editingOrder) {
      setEditingOrder((prevOrder) => ({
        ...prevOrder,
        [name]: value
      }));
    } else if (editingUser) {
      setEditingUser((prevUser) => ({
        ...prevUser,
        [name]: value
      }));
    }
  };

  const handleSaveOrderClick = () => {
    setOrders((prevOrders) =>
      prevOrders.map((order) =>
        order.id === editingOrder.id ? editingOrder : order
      )
    );
    setEditingOrder(null);
  };

  const handleEditUserClick = (user) => {
    setEditingUser(user);
  };

  const handleSaveUserClick = () => {
    setUsers((prevUsers) =>
      prevUsers.map((user) =>
        user.id === editingUser.id ? editingUser : user
      )
    );
    setEditingUser(null);
  };

  return (
    <div className="p-4 sm:p-6 bg-gradient-to-b from-white via-blue-100 to-white min-h-screen flex flex-col">
      <header className="bg-blue-300 p-2 sm:p-4 rounded-lg shadow-md mb-4 sm:mb-6">
        <h1 className="text-xl sm:text-2xl font-bold text-blue-900 mb-2 sm:mb-4">Vendor Dashboard</h1>
      </header>
      <div className="flex-grow bg-white p-4 sm:p-6 rounded-lg shadow-md">
        <h2 className="text-2xl sm:text-3xl font-semibold text-blue-700 mb-2 sm:mb-4">Total Orders: {orders.length}</h2>
        <table className="w-full table-auto border-collapse mb-4 sm:mb-6">
          <thead>
            <tr className="bg-blue-50">
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">ID</th>
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">Customer</th>
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">Item</th>
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">Quantity</th>
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">Status</th>
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">Actions</th>
            </tr>
          </thead>
          <tbody>
            {orders.map((order) => (
              <tr key={order.id} className="hover:bg-blue-50">
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left text-sm sm:text-base">{order.id}</td>
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left text-sm sm:text-base">{order.customerName}</td>
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left text-sm sm:text-base">{order.item}</td>
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left text-sm sm:text-base">{order.quantity}</td>
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left text-sm sm:text-base">{order.status}</td>
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left">
                  <button
                    onClick={() => handleEditOrderClick(order)}
                    className="bg-blue-600 text-white text-sm sm:text-base px-3 sm:px-4 py-1 sm:py-2 rounded hover:bg-blue-700"
                  >
                    Edit
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        {editingOrder && (
          <div className="mt-4 sm:mt-6 p-4 sm:p-6 bg-blue-50 rounded-lg shadow-md">
            <h3 className="text-2xl sm:text-3xl font-semibold text-blue-700 mb-2 sm:mb-4">Edit Order</h3>
            <form>
              <div className="mb-2 sm:mb-4">
                <label className="block text-blue-600 text-sm sm:text-base">Customer Name</label>
                <input
                  type="text"
                  name="customerName"
                  value={editingOrder.customerName}
                  onChange={handleInputChange}
                  className="mt-1 p-2 border border-blue-300 rounded w-full text-sm sm:text-base"
                />
              </div>
              <div className="mb-2 sm:mb-4">
                <label className="block text-blue-600 text-sm sm:text-base">Item</label>
                <input
                  type="text"
                  name="item"
                  value={editingOrder.item}
                  onChange={handleInputChange}
                  className="mt-1 p-2 border border-blue-300 rounded w-full text-sm sm:text-base"
                />
              </div>
              <div className="mb-2 sm:mb-4">
                <label className="block text-blue-600 text-sm sm:text-base">Quantity</label>
                <input
                  type="number"
                  name="quantity"
                  value={editingOrder.quantity}
                  onChange={handleInputChange}
                  className="mt-1 p-2 border border-blue-300 rounded w-full text-sm sm:text-base"
                />
              </div>
              <div className="mb-2 sm:mb-4">
                <label className="block text-blue-600 text-sm sm:text-base">Status</label>
                <select
                  name="status"
                  value={editingOrder.status}
                  onChange={handleInputChange}
                  className="mt-1 p-2 border border-blue-300 rounded w-full text-sm sm:text-base"
                >
                  <option value="Shipped">Shipped</option>
                  <option value="Pending">Pending</option>
                  <option value="Delivered">Delivered</option>
                </select>
              </div>
              <button
                type="button"
                onClick={handleSaveOrderClick}
                className="bg-green-600 text-white text-sm sm:text-base px-3 sm:px-4 py-1 sm:py-2 rounded hover:bg-green-700"
              >
                Save
              </button>
            </form>
          </div>
        )}
        <h2 className="text-2xl sm:text-3xl font-semibold text-blue-700 mt-8 mb-4">Users</h2>
        <table className="w-full table-auto border-collapse mb-4 sm:mb-6">
          <thead>
            <tr className="bg-blue-50">
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">ID</th>
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">Name</th>
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">Email</th>
              <th className="border px-2 sm:px-4 py-1 sm:py-2 text-blue-800 text-left text-sm sm:text-base">Actions</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user) => (
              <tr key={user.id} className="hover:bg-blue-50">
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left text-sm sm:text-base">{user.id}</td>
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left text-sm sm:text-base">{user.name}</td>
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left text-sm sm:text-base">{user.email}</td>
                <td className="border px-2 sm:px-4 py-1 sm:py-2 text-left">
                  <button
                    onClick={() => handleEditUserClick(user)}
                    className="bg-blue-600 text-white text-sm sm:text-base px-3 sm:px-4 py-1 sm:py-2 rounded hover:bg-blue-700"
                  >
                    Edit
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        {editingUser && (
          <div className="mt-4 sm:mt-6 p-4 sm:p-6 bg-blue-50 rounded-lg shadow-md">
            <h3 className="text-2xl sm:text-3xl font-semibold text-blue-700 mb-2 sm:mb-4">Edit User</h3>
            <form>
              <div className="mb-2 sm:mb-4">
                <label className="block text-blue-600 text-sm sm:text-base">Name</label>
                <input
                  type="text"
                  name="name"
                  value={editingUser.name}
                  onChange={handleInputChange}
                  className="mt-1 p-2 border border-blue-300 rounded w-full text-sm sm:text-base"
                />
              </div>
              <div className="mb-2 sm:mb-4">
                <label className="block text-blue-600 text-sm sm:text-base">Email</label>
                <input
                  type="email"
                  name="email"
                  value={editingUser.email}
                  onChange={handleInputChange}
                  className="mt-1 p-2 border border-blue-300 rounded w-full text-sm sm:text-base"
                />
              </div>
              <button
                type="button"
                onClick={handleSaveUserClick}
                className="bg-green-600 text-white text-sm sm:text-base px-3 sm:px-4 py-1 sm:py-2 rounded hover:bg-green-700"
              >
                Save
              </button>
            </form>
          </div>
        )}
      </div>
      <footer className="bg-blue-200 p-2 sm:p-4 rounded-lg mt-4 sm:mt-6 text-center">
        <p className="text-blue-800 text-sm sm:text-base">© 2024 Vendor Dashboard. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default VendorDashboard;
