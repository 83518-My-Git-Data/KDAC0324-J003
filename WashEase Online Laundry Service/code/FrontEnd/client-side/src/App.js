import logo from './logo.svg';
import './App.css';
import Login from './components/Login';
import Signup from './components/Signup';
import Landingpage from './components/Landingpage';
import AddToCartPage from './components/AddToCartPage';


function App() {
  return (
    <div className="App">
      <Route path="/" element={<Login />} />
      <Route path="/signup" element={<Signup />} />
      <Route path="/landing-page" element={<Landingpage />} />
      <Route path="/add-to-cart-page" element={<AddToCartPage />} />
     

      
    </div>
  );
}

export default App;
