import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Card from './Card'; // Import your Card component

const LandingPage = () => {
  const [expandedFAQ, setExpandedFAQ] = useState(null);
  const navigate = useNavigate();

  const toggleFAQ = (index) => {
    setExpandedFAQ(expandedFAQ === index ? null : index);
  };

  const handleBookNow = () => {
    navigate('/vendor-selection');
  };

  return (
    <div className="font-sans min-h-screen flex flex-col">
      {/* Navbar */}
      <nav className="bg-blue-100 text-gray-800 p-4">
        <div className="container mx-auto flex justify-between items-center">
          <h1 className="text-3xl font-bold">MyService</h1>
          <ul className="flex space-x-4 text-base">
            <li><a href="#current-orders" className="hover:text-blue-500">Current Orders</a></li>
            <li><a href="#previous-orders" className="hover:text-blue-500">Previous Orders</a></li>
            <li><a href="#about-us" className="hover:text-blue-500">About Us</a></li>
            <li><a href="#testimonials" className="hover:text-blue-500">Testimonials</a></li>
            <li><a href="#faq" className="hover:text-blue-500">FAQ</a></li>
          </ul>
        </div>
      </nav>

      {/* Current Orders Section */}
      <section id="current-orders" className="p-8 bg-blue-50 mx-auto mt-8" style={{ width: '80%' }}>
        <div>
          <h2 className="text-2xl font-bold mb-4 text-left">Current Orders</h2>
          <div className="bg-white p-4 rounded-lg shadow-lg">
            <table className="w-full table-auto border-collapse">
              <thead className="bg-blue-200 text-gray-800 text-base">
                <tr>
                  <th className="p-3 border-b text-center">Order ID</th>
                  <th className="p-3 border-b text-center">Status</th>
                  <th className="p-3 border-b text-center">Service</th>
                  <th className="p-3 border-b text-center">Details</th>
                </tr>
              </thead>
              <tbody>
                <tr className="border-b hover:bg-blue-50">
                  <td className="p-3 text-sm text-center">#12345</td>
                  <td className="p-3 text-sm text-center">In Progress</td>
                  <td className="p-3 text-sm text-center">Laundry</td>
                  <td className="p-3 text-sm text-center">Estimated Completion: August 10, 2024</td>
                </tr>
                <tr className="border-b hover:bg-blue-50">
                  <td className="p-3 text-sm text-center">#12346</td>
                  <td className="p-3 text-sm text-center">Scheduled</td>
                  <td className="p-3 text-sm text-center">Cleaning</td>
                  <td className="p-3 text-sm text-center">Scheduled Date: August 12, 2024</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </section>

      {/* Previous Orders Section */}
      <section id="previous-orders" className="p-8 mx-auto" style={{ width: '80%' }}>
        <div>
          <h2 className="text-2xl font-bold mb-4 text-left">Previous Orders</h2>
          <div className="bg-white p-4 rounded-lg shadow-lg">
            <table className="w-full table-auto border-collapse">
              <thead className="bg-blue-200 text-gray-800 text-base">
                <tr>
                  <th className="p-3 border-b text-center">Order ID</th>
                  <th className="p-3 border-b text-center">Status</th>
                  <th className="p-3 border-b text-center">Service</th>
                  <th className="p-3 border-b text-center">Details</th>
                </tr>
              </thead>
              <tbody>
                <tr className="border-b hover:bg-blue-50">
                  <td className="p-3 text-sm text-center">#12344</td>
                  <td className="p-3 text-sm text-center">Completed</td>
                  <td className="p-3 text-sm text-center">Laundry</td>
                  <td className="p-3 text-sm text-center">Completed Date: July 30, 2024</td>
                </tr>
                <tr className="border-b hover:bg-blue-50">
                  <td className="p-3 text-sm text-center">#12343</td>
                  <td className="p-3 text-sm text-center">Completed</td>
                  <td className="p-3 text-sm text-center">Cleaning</td>
                  <td className="p-3 text-sm text-center">Completed Date: July 25, 2024</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </section>

      {/* Book Service Button */}
      <section className="p-8 text-gray-800 text-center mx-auto" style={{ width: '80%' }}>
        <div>
          <h2 className="text-2xl font-bold mb-4">Book a Service</h2>
          <button 
            onClick={handleBookNow}
            className="bg-white text-blue-500 py-2 px-4 rounded-lg font-bold text-lg"
          >
            Book Now
          </button>
        </div>
      </section>

      {/* About Us Section */}
      <section id="about-us" className="p-8 bg-blue-50 mx-auto" style={{ width: '80%' }}>
        <div>
          <h2 className="text-2xl font-bold mb-4 text-left">About Us</h2>
          <div className="bg-white p-6 rounded-lg shadow-lg text-gray-800 leading-relaxed">
            <p className="text-base mb-4">
              Welcome to Washease, your premier laundry and service platform dedicated to simplifying your life with top-notch convenience and efficiency. At Washease, we understand that your time is valuable, and our mission is to provide a seamless and reliable service experience for all your laundry and cleaning needs.
            </p>
            <p className="text-base mb-4">
              Founded with the vision to revolutionize the way you manage your laundry and household tasks, Washease combines cutting-edge technology with exceptional customer service. Our user-friendly platform allows you to schedule pickups and deliveries, track your orders in real-time, and access a range of services from the comfort of your home.
            </p>
            <p className="text-base mb-4">
              Our team consists of highly trained professionals who are committed to delivering quality service with attention to detail. We take pride in our rigorous quality control processes and our commitment to using eco-friendly products, ensuring that your clothes and home are treated with the utmost care.
            </p>
            <p className="text-base mb-4">
              At Washease, we believe in transparency, reliability, and customer satisfaction. Our platform is designed to make your life easier, allowing you to focus on what matters most while we take care of the rest. Whether you need laundry, cleaning, or other household services, we are here to meet your needs with unparalleled convenience and efficiency.
            </p>
            <p className="text-base mb-4">
              Thank you for choosing Washease. We look forward to serving you and making your daily routine smoother and more enjoyable.
            </p>
          </div>
        </div>
      </section>

      {/* Testimonials Section */}
      <section id="testimonials" className="p-8 mx-auto" style={{ width: '80%' }}>
        <div>
          <h2 className="text-2xl font-bold mb-4">Testimonials</h2>
          <div className="grid gap-6 md:grid-cols-1 lg:grid-cols-2">
            <Card
              title="John Doe"
              description="Washease has completely transformed how I handle my laundry. The service is prompt, and the quality is top-notch. Highly recommended!"
              className="flex flex-col items-center"
            />
            <Card
              title="Jane Smith"
              description="The convenience of Washease is unmatched. Scheduling a pickup was a breeze, and my clothes came back looking brand new. Excellent service!"
              className="flex flex-col items-center"
            />
            <Card
              title="Mike Johnson"
              description="I love how Washease takes care of everything. From pickup to delivery, they handle it all with professionalism and care."
              className="flex flex-col items-center"
            />
            <Card
              title="Emily Davis"
              description="Washease has made managing my home chores so much easier. Their attention to detail and customer service are exceptional. I wouldn’t use any other service."
              className="flex flex-col items-center"
            />
          </div>
        </div>
      </section>

      {/* FAQ Section */}
      <section id="faq" className="p-8 bg-blue-50 mx-auto mb-8" style={{ width: '80%' }}>
        <div>
          <h2 className="text-2xl font-bold mb-4 text-left">FAQ</h2>
          <div className="bg-white p-4 rounded-lg shadow-lg">
            <div className="mb-4">
              <h3 
                className="text-lg font-semibold mb-2 cursor-pointer text-left" 
                onClick={() => toggleFAQ(1)}
                style={{ borderBottom: '2px solid #ddd', paddingBottom: '2px' }}
              >
                What services do you offer?
              </h3>
              <div className={`overflow-hidden transition-all duration-500 ${expandedFAQ === 1 ? 'max-h-screen' : 'max-h-0'}`}>
                <p className="text-sm mb-2 text-left pl-2">We offer a range of services including laundry, cleaning, and more. For a full list of services, please visit our services page.</p>
              </div>
            </div>
            <div className="mb-4">
              <h3 
                className="text-lg font-semibold mb-2 cursor-pointer text-left" 
                onClick={() => toggleFAQ(2)}
                style={{ borderBottom: '2px solid #ddd', paddingBottom: '2px' }}
              >
                How can I contact customer support?
              </h3>
              <div className={`overflow-hidden transition-all duration-500 ${expandedFAQ === 2 ? 'max-h-screen' : 'max-h-0'}`}>
                <p className="text-sm mb-2 text-left pl-2">You can contact customer support via email at support@myservice.com or call us at (123) 456-7890.</p>
              </div>
            </div>
            <div>
              <h3 
                className="text-lg font-semibold mb-2 cursor-pointer text-left" 
                onClick={() => toggleFAQ(3)}
                style={{ borderBottom: '2px solid #ddd', paddingBottom: '2px' }}
              >
                What is your cancellation policy?
              </h3>
              <div className={`overflow-hidden transition-all duration-500 ${expandedFAQ === 3 ? 'max-h-screen' : 'max-h-0'}`}>
                <p className="text-sm mb-2 text-left pl-2">Cancellations must be made at least 24 hours in advance. Please refer to our cancellation policy page for more details.</p>
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="bg-blue-100 text-gray-800 p-4 mt-auto">
        <div className="container mx-auto text-center">
          <p className="text-base">&copy; {new Date().getFullYear()} MyService. All rights reserved.</p>
          <p className="text-base">123 Main Street, City, Country</p>
          <p className="text-base">Contact us: <a href="mailto:support@myservice.com" className="text-blue-500">support@myservice.com</a></p>
        </div>
      </footer>
    </div>
  );
};

export default LandingPage;
