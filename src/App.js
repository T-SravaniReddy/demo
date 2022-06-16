import './App.css';
import React  from 'react';
import {
  BrowserRouter as Router,
  Routes,
  Route,
 // Navigate,
  Link,
} from "react-router-dom";

import Register from './Register';
import Home from './Home';
import Login from './Login';
import Aftersignup from './Aftersignup';
import NewExpense from './NewExpense';





function App() {
  return (
      <Router>
        <Routes>
          <Route exact path="/" element={<Home/>} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/process_register" element={<Aftersignup />} /> 
          <Route path="/new" element={<NewExpense />} /> 
        </Routes>
      </Router>
  );
}

export default App;



