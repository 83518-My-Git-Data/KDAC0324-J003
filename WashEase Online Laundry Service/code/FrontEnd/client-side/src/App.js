import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <Route path="/" element={<Login />} />
      <Route path="/signup" element={<Signup />} />
      <Route path="/landing-page" element={<Landingpage />} />
    </div>
  );
}

export default App;
