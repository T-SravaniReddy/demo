import React from 'react'
import {Link} from 'react-router-dom'
const Aftersignup = props => {

  const { email, password, FN , LN } =
    (props.location && props.location.state) || {};

  return (
    <div>
        <h3 className="center">You have signed up successfully!</h3>
        <Link to="/login"><h3 className="ele">Click here to Login</h3></Link>
    </div>
  )
}

export default Aftersignup