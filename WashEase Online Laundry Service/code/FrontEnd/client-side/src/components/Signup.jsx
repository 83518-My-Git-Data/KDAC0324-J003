import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Signup = () => {
    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: '',
        role: '',
        phoneNumber: '',
        registrationDate: new Date().toISOString(),
    });
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const validateForm = () => {
        const { username, email, password, role, phoneNumber } = formData;
        return username && email && password && role && phoneNumber && /^[\d\+\-\(\)\s]*$/.test(phoneNumber);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!validateForm()) {
            setError('Please fill in all fields correctly.');
            return;
        }

        setLoading(true);
        setError('');

        try {
            const response = await axios.post('http://localhost:8080/user/register', formData, {
                headers: {
                    'Content-Type': 'application/json',
                },
            });
            console.log('Registration successful', response.data);
            navigate('/login');
        } catch (error) {
            console.error('Registration error', error);
            setError(error.response?.data?.message || 'Registration failed. Please try again.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="bg-blue-100 flex flex-col items-center justify-center min-h-screen p-4">
            <div className="w-full max-w-md bg-white p-6 rounded-lg shadow-lg">
                <h2 className="text-2xl font-semibold mb-4 text-gray-800 text-center">Sign Up</h2>
                <form onSubmit={handleSubmit}>
                    {error && <p className="text-red-600 text-base mb-4 text-center">{error}</p>}
                    
                    <div className="mb-4">
                        <label htmlFor="username" className="block text-gray-700 text-base font-semibold mb-1 text-left">Username</label>
                        <input
                            type="text"
                            id="username"
                            name="username"
                            value={formData.username}
                            onChange={handleChange}
                            placeholder="Enter your username"
                            className="w-full px-3 py-2 border border-gray-300 rounded-lg text-sm focus:outline-none focus:border-blue-500"
                            required
                        />
                    </div>

                    <div className="mb-4">
                        <label htmlFor="email" className="block text-gray-700 text-base font-semibold mb-1 text-left">Email</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            value={formData.email}
                            onChange={handleChange}
                            placeholder="Enter your email"
                            className="w-full px-3 py-2 border border-gray-300 rounded-lg text-sm focus:outline-none focus:border-blue-500"
                            required
                        />
                    </div>

                    <div className="mb-4">
                        <label htmlFor="password" className="block text-gray-700 text-base font-semibold mb-1 text-left">Password</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            value={formData.password}
                            onChange={handleChange}
                            placeholder="Enter your password"
                            className="w-full px-3 py-2 border border-gray-300 rounded-lg text-sm focus:outline-none focus:border-blue-500"
                            required
                        />
                    </div>

                    <div className="mb-4">
                        <label htmlFor="role" className="block text-gray-700 text-base font-semibold mb-1 text-left">Role</label>
                        <select
                            id="role"
                            name="role"
                            value={formData.role}
                            onChange={handleChange}
                            className="w-full px-3 py-2 border border-gray-300 rounded-lg text-sm focus:outline-none focus:border-blue-500"
                            required
                        >
                            <option value="">Select your role</option>
                            <option value="ROLE_VENDOR">ROLE_VENDOR</option>
                            <option value="ROLE_USER">ROLE_USER</option>
                        </select>
                    </div>

                    <div className="mb-4">
                        <label htmlFor="phoneNumber" className="block text-gray-700 text-base font-semibold mb-1 text-left">Phone Number</label>
                        <input
                            type="text"
                            id="phoneNumber"
                            name="phoneNumber"
                            value={formData.phoneNumber}
                            onChange={handleChange}
                            placeholder="Enter your phone number"
                            className="w-full px-3 py-2 border border-gray-300 rounded-lg text-sm focus:outline-none focus:border-blue-500"
                            required
                        />
                    </div>

                    <button
                        type="submit"
                        className={`w-full ${loading ? 'bg-gray-500' : 'bg-blue-500'} text-white px-3 py-2 rounded-lg text-sm hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-opacity-50`}
                        disabled={loading}
                    >
                        {loading ? 'Signing Up...' : 'Sign Up'}
                    </button>
                </form>

                <div className="mt-4 text-center">
                    <p className="text-gray-600 text-sm">Already have an account?</p>
                    <button
                        onClick={() => navigate('/login')}
                        className="mt-2 text-blue-500 text-sm hover:underline"
                    >
                        Login here
                    </button>
                </div>
            </div>

            <footer className="text-center text-gray-600 text-sm mt-6">
                <p>&copy; {new Date().getFullYear()} WashEase Pvt Limited. All rights reserved.</p>
            </footer>
        </div>
    );
};

export default Signup;
