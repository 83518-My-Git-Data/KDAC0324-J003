import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const AddressPage = () => {
  const [formData, setFormData] = useState({
    buildingName: '',
    streetName: '',
    area: '',
    city: '',
    state: '',
    country: '',
    pincode: '',
  });

  const [feedback, setFeedback] = useState('');
  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const validateForm = () => {
    return Object.values(formData).every(field => field.trim() !== '');
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    if (!validateForm()) {
      setFeedback('Please fill in all fields.');
      return;
    }

    setLoading(true);
    setFeedback('');

   
    setTimeout(() => {
     
      setFeedback('Address added successfully!');
      setFormData({
        buildingName: '',
        streetName: '',
        area: '',
        city: '',
        state: '',
        country: '',
        pincode: '',
      });
      navigate('/order-placed');
      setLoading(false);
    }, 1000);
  };

  return (
    <div className="bg-light-blue-50 min-h-screen flex flex-col">
      <nav className="bg-blue-300 text-white p-4">
        <h1 className="text-3xl font-bold">WashEase</h1>
      </nav>

      <div className="flex-1 p-4">
        <div className="max-w-lg mx-auto p-4 bg-white shadow-md rounded-lg mt-8">
          <h2 className="text-2xl font-bold mb-4">Address Page</h2>
          <form onSubmit={handleSubmit}>
            {['buildingName', 'streetName', 'area', 'city', 'state', 'country', 'pincode'].map((field) => (
              <div key={field} className="mb-4">
                <label htmlFor={field} className="block text-gray-700 capitalize">
                  {field.replace(/([A-Z])/g, ' $1')}
                </label>
                <input
                  type="text"
                  id={field}
                  name={field}
                  value={formData[field]}
                  onChange={handleChange}
                  className="mt-1 block w-full border-gray-300 rounded-md shadow-sm focus:border-blue-500 focus:ring focus:ring-blue-500 focus:ring-opacity-50"
                />
              </div>
            ))}
            {feedback && (
              <div className={`mb-4 p-2 rounded-md ${feedback.includes('Error') ? 'bg-red-200 text-red-800' : 'bg-green-200 text-green-800'}`}>
                {feedback}
              </div>
            )}
            <button
              type="submit"
              disabled={loading}
              className={`w-full py-2 px-4 rounded-md ${loading ? 'bg-blue-300' : 'bg-blue-500 hover:bg-blue-600'} text-white focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-opacity-50`}
            >
              {loading ? 'Adding...' : 'Add Address'}
            </button>
          </form>
        </div>
      </div>

      <footer className="bg-blue-300 text-white text-center py-2 mt-auto">
        <p className="text-base">© 2024 WashEase. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default AddressPage;
