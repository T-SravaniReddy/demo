
import React, { Component } from 'react'
import { useState } from 'react';
import { propTypes } from 'react-bootstrap/esm/Image';
import {Redirect,Route, Link} from 'react-router-dom'
import Aftersignup from './Aftersignup';
//class Register extends Component {
const Register = props => {
    const [state, setState] = useState({
      email: "",
      password: "",
      FN: "",
      LN: "",
    });
  
  const handleInputChange = event => {
    const {name, value} = event.target;
    setState(prevState => ({
      ...prevState,
      [name]: value
    }));
    console.log(state)
  }
    


    return (
        <div className='center'>
      <div className="center">
        <h1>User Registration-Sign Up</h1>
          <form>
            <table className="tab">
              <tr>
          <td><label>E-mail:</label></td>
          <td><input type="text" name="email" className="input" onChange={handleInputChange}></input></td>
          </tr>
          <p></p>
          <tr>          
          <td><label>Password:  </label></td>
          <td><input type="password" name="password" className="input" onChange={handleInputChange}></input></td> 
         </tr>
         <p></p>
         <tr>
          <td><label>First Name:  </label></td>
          <td><input type="text" name="FN" className="input" onChange={handleInputChange}></input></td>
          </tr>
          <p></p>
          <tr>
           <td><label>Last Name:  </label></td>
          <td><input type="text" name="LN" className="input" onChange={handleInputChange}></input></td>
          </tr>
          </table>
          <p></p>
          <Link className='btn btn-primary' to={{pathname:"/process_register", state: state}}>Sign Up</Link>
          </form>
        </div>
        </div>
        
    )
}


export default Register;