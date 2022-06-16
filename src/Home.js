import React from "react";
import Aftersignup from "./Aftersignup";
import {
    Link,
    Route,
  } from "react-router-dom";
function Home() {
  return <div>  <center><h1><b>Welcome to Wealth Management Application!</b></h1>
      <nav>
          
          <Link to="/" style={{ textDecoration: 'none' }}><h4><b> Welcome</b></h4> </Link>
          <Link to="/register"  style={{ textDecoration: 'none' }}><h4><b> Register </b></h4></Link>
          <Link to="/login"  style={{ textDecoration: 'none' }}><h4><b>Login</b></h4></Link>
        </nav>
        </center>
  </div>;
}

export default Home;
