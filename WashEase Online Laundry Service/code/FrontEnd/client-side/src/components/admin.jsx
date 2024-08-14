import React, { useState } from 'react';

const AdminPage = () => {
  // Updated with more vendors and users
  const [vendors, setVendors] = useState([
    { id: 1, name: 'Vendor A' },
    { id: 2, name: 'Vendor B' },
    { id: 3, name: 'Vendor C' },
    { id: 4, name: 'Vendor D' },
    { id: 5, name: 'Vendor E' },
    { id: 6, name: 'Vendor F' },
    { id: 7, name: 'Vendor G' },
    { id: 8, name: 'Vendor H' },
    { id: 9, name: 'Vendor I' },
    { id: 10, name: 'Vendor J' }
  ]);

  const [users, setUsers] = useState([
    { id: 1, name: 'User A' },
    { id: 2, name: 'User B' },
    { id: 3, name: 'User C' },
    { id: 4, name: 'User D' },
    { id: 5, name: 'User E' },
    { id: 6, name: 'User F' },
    { id: 7, name: 'User G' },
    { id: 8, name: 'User H' },
    { id: 9, name: 'User I' },
    { id: 10, name: 'User J' }
  ]);

  const deleteVendor = (id) => {
    setVendors(vendors.filter(vendor => vendor.id !== id));
  };

  const deleteUser = (id) => {
    setUsers(users.filter(user => user.id !== id));
  };

  const editVendor = (id, newName) => {
    setVendors(vendors.map(vendor => vendor.id === id ? { ...vendor, name: newName } : vendor));
  };

  const editUser = (id, newName) => {
    setUsers(users.map(user => user.id === id ? { ...user, name: newName } : user));
  };

  return (
    <div className="min-h-screen bg-blue-50 p-3 flex flex-col">
      <div className="flex-grow">
        <h1 className="text-2xl font-bold mb-3 text-center">Admin Dashboard</h1>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-3">
          <div className="bg-white p-3 rounded-lg shadow-lg overflow-auto">
            <h2 className="text-xl font-semibold mb-2">Manage Vendors</h2>
            <p className="text-sm mb-2 text-gray-600">Manage the list of vendors. Edit their names or delete them.</p>
            <ul>
              {vendors.map(vendor => (
                <li key={vendor.id} className="flex justify-between items-center mb-1 p-2 border-b border-gray-300">
                  <span className="text-lg font-medium">{vendor.name}</span>
                  <div>
                    <button 
                      onClick={() => editVendor(vendor.id, prompt('New Vendor Name:', vendor.name))}
                      className="bg-blue-500 text-white px-3 py-1 rounded-md mr-2 text-sm hover:bg-blue-600"
                    >
                      Edit
                    </button>
                    <button 
                      onClick={() => deleteVendor(vendor.id)}
                      className="bg-red-500 text-white px-3 py-1 rounded-md text-sm hover:bg-red-600"
                    >
                      Delete
                    </button>
                  </div>
                </li>
              ))}
            </ul>
          </div>

          <div className="bg-white p-3 rounded-lg shadow-lg overflow-auto">
            <h2 className="text-xl font-semibold mb-2">Manage Users</h2>
            <p className="text-sm mb-2 text-gray-600">Manage the list of users. Edit their names or remove them.</p>
            <ul>
              {users.map(user => (
                <li key={user.id} className="flex justify-between items-center mb-1 p-2 border-b border-gray-300">
                  <span className="text-lg font-medium">{user.name}</span>
                  <div>
                    <button 
                      onClick={() => editUser(user.id, prompt('New User Name:', user.name))}
                      className="bg-blue-500 text-white px-3 py-1 rounded-md mr-2 text-sm hover:bg-blue-600"
                    >
                      Edit
                    </button>
                    <button 
                      onClick={() => deleteUser(user.id)}
                      className="bg-red-500 text-white px-3 py-1 rounded-md text-sm hover:bg-red-600"
                    >
                      Delete
                    </button>
                  </div>
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
      <footer className="bg-gray-800 text-white text-center py-1 mt-auto">
        <p className="text-sm">© 2024 Admin Dashboard. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default AdminPage;
