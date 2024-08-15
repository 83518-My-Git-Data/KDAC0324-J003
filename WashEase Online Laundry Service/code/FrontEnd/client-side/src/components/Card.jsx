import React from 'react';

const Card = ({ title, description, onBookService, className }) => {
  return (
    <div className={`border rounded p-4 shadow-md ${className}`}>
      <h3 className="text-xl font-semibold mb-2">{title}</h3>
      <p className="text-gray-700 mb-4">{description}</p>
      <button
        onClick={onBookService}
        className="bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600"
      >
        Book Service
      </button>
    </div>
  );
};

export default Card;
