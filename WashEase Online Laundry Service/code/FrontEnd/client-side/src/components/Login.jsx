import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios'; // Import axios for making HTTP requests

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState({
    username: '',
    password: '',
  });
  const navigate = useNavigate(); // Hook for navigation

  const validateForm = () => {
    let isValid = true;
    const errors = { username: '', password: '' };

    if (!username.trim()) {
      errors.username = 'Username is required';
      isValid = false;
    }

    if (!password.trim()) {
      errors.password = 'Password is required';
      isValid = false;
    }

    setErrors(errors);
    return isValid;
  };

  const handleAdminLogin = () => {
    // Hardcoded credentials check
    const adminCredentials = {
      Harish: '1234',
      Ronak: '1234',
      Saurabh: '1234',
      Ayush: '1234',
    };

    if (adminCredentials[username] === password) {
      navigate('/admin'); // Navigate to Admin Dashboard
      return true;
    }

    return false;
  };

  const login = async (email, password) => {
    try {
      const response = await axios.post('http://localhost:8080/auth/login', { email, password });
      return response.data;
    } catch (error) {
      console.error('Login failed:', error);
      return null;
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (validateForm()) {
      // Check for admin credentials first
      if (handleAdminLogin()) {
        // Admin login successful, no need to check server
        return;
      }

      // Regular login attempt
      const result = await login(username, password);

      // Persist the token and username in session
      if (result != null) {
        sessionStorage.setItem('name', result.firstName);
        sessionStorage.setItem('token', result.jwt);
        sessionStorage.setItem('role', result.role);
        alert('Login Successful'); // Replace toast with alert
        navigate('/home'); // Navigate to Home page on successful login
      } else {
        alert('Login Failed! Invalid Credentials'); // Replace toast with alert
      }
    }
  };

  const handleCreateAccount = () => {
    navigate('/signup'); // Navigate to Signup page
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-blue-50">
      <div className="w-full max-w-2xl h-auto p-8">
        <form
          className="bg-white shadow-md rounded px-10 pt-8 pb-10 mb-6"
          onSubmit={handleSubmit}
        >
          <h2 className="text-4xl font-extrabold mb-8 text-center">Login</h2>
          <div className="mb-6">
            <label className="block text-gray-700 text-2xl font-semibold mb-3 text-left" htmlFor="username">
              Username
            </label>
            <input
              className={`shadow appearance-none border rounded w-full py-3 px-4 text-gray-700 leading-tight focus:outline-none focus:shadow-outline ${
                errors.username ? 'border-red-600' : ''
              }`}
              id="username"
              type="text"
              placeholder="Username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
            {errors.username && (
              <p className="text-red-600 text-sm italic mt-1">{errors.username}</p>
            )}
          </div>
          <div className="mb-8">
            <label className="block text-gray-700 text-2xl font-semibold mb-3 text-left" htmlFor="password">
              Password
            </label>
            <input
              className={`shadow appearance-none border rounded w-full py-3 px-4 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline ${
                errors.password ? 'border-red-600' : ''
              }`}
              id="password"
              type="password"
              placeholder="******************"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            {errors.password && (
              <p className="text-red-600 text-sm italic mt-1">{errors.password}</p>
            )}
            <p className="text-gray-600 text-2xl mt-2">Please choose a password.</p>
          </div>
          <div className="flex items-center justify-between mb-6">
            <button
              className="bg-blue-600 hover:bg-blue-800 text-white font-bold py-3 px-6 rounded focus:outline-none focus:shadow-outline"
              type="submit"
            >
              Sign In
            </button>
            <a
              className="inline-block align-baseline font-bold text-md text-blue-600 hover:text-blue-800"
              href="#"
              onClick={() => navigate('/forgot-password')} // Navigate to ForgotPassword page
            >
              Forgot Password?
            </a>
          </div>

          <div className="text-center">
            <p className="text-gray-600 text-lg mb-4">Don't have an account?</p>
            <button
              className="bg-green-600 hover:bg-green-800 text-white font-bold py-3 px-6 rounded focus:outline-none focus:shadow-outline"
              onClick={handleCreateAccount}
            >
              Create Account
            </button>
          </div>
        </form>
        <p className="text-center text-gray-500 text-2xl mt-4">
          &copy;2024 WashEase Limited. All rights reserved.
        </p>
      </div>
    </div>
  );
};

export default Login;
