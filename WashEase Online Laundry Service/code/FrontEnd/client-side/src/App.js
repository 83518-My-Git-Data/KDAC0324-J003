import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <Route path="/signup" element={<Signup />} />
    </div>
  );
}

export default App;
