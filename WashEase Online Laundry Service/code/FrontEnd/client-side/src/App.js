import logo from './logo.svg';
import './App.css';
import Login from './components/Login';
import Signup from './components/Signup';
import Landingpage from './components/Landingpage';
import AddToCartPage from './components/AddToCartPage';
import VendorSelection from './components/VendorSelection';
import AdminPage from './components/admin';
function App() {
  return (
    <div className="App">
      <Route path="/" element={<Login />} />
      <Route path="/signup" element={<Signup />} />
      <Route path="/landing-page" element={<Landingpage />} />
      <Route path="/add-to-cart-page" element={<AddToCartPage />} />
      <Route path="/vendor-selection" element={<VendorSelection />} />
      <Route path="/admin" element={<AdminPage />} />
      
    </div>
  );
}

export default App;
