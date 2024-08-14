import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate for navigation
import Card from '../components/Card'; // Adjust the path if necessary
import '../index.css'; // Ensure Tailwind CSS is included

const cardData = [
  // New vendors only
  {
    title: "Dhobi",
    description: "Professional laundry services including washing, drying, and ironing. We offer quick turnaround and quality service.",
    image: "https://via.placeholder.com/400x250",
    pincode: "12345"
  },
  {
    title: "Sachin Laundry",
    description: "Reliable laundry service with a focus on customer satisfaction. We provide washing, drying, and folding services.",
    image: "https://via.placeholder.com/400x250",
    pincode: "12346"
  },
  {
    title: "Tuljai Dry Cleaning",
    description: "Expert dry cleaning services for delicate fabrics. We handle all types of garments with care and precision.",
    image: "https://via.placeholder.com/400x250",
    pincode: "12347"
  },
  {
    title: "Ask Laundry",
    description: "Comprehensive laundry solutions including washing, dry cleaning, and special treatments. Quick service and quality guaranteed.",
    image: "https://via.placeholder.com/400x250",
    pincode: "12348"
  }
];

const VendorSelection = () => {
  const [pincode, setPincode] = useState('');
  const navigate = useNavigate(); // Hook for navigation
  
  const filteredVendors = pincode
    ? cardData.filter(vendor => vendor.pincode === pincode)
    : cardData;

  const handleBookService = (vendorName) => {
    // Navigate to the AddToCart page with the vendor name
    navigate('/add-to-cart-page', { state: { vendorName } });
  };

  return (
    <div className="flex flex-col min-h-screen">
      <main className="flex flex-col flex-grow p-6">
        
        <div className="mb-6">
          <input
            type="text"
            placeholder="Enter pincode to filter vendors"
            value={pincode}
            onChange={(e) => setPincode(e.target.value)}
            className="p-2 border rounded w-full md:w-1/3 lg:w-1/4"
          />
        </div>
        
        <div className="flex flex-wrap justify-center gap-6">
          {filteredVendors.length > 0 ? (
            filteredVendors.map((card, index) => (
              <Card
                key={index}
                title={card.title}
                description={card.description}
                image={card.image}
                onBookService={() => handleBookService(card.title)}
                className="w-full md:w-80 lg:w-96" 
              />
            ))
          ) : (
            <p>No vendors found for this pincode.</p>
          )}
        </div>
      </main>
      <footer className="bg-gray-800 text-white text-center py-4">
        <p>&copy; 2024 WashEase. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default VendorSelection;
