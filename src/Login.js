import React, { Component } from 'react'
class Login extends Component {
  constructor(props) {
    super(props)
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  componentDidMount(){
    document.body.style.backgroundColor="lightgrey"
  }
  handleSubmit(event) {
    
    window.location.href="./new"
    event.preventDefault();
  }
  render() {
    return (
      <div>
      <form className="center" onSubmit={this.handleSubmit}>
      <h3>Please sign in</h3>
      <input type="text" name="email" placeholder='e-mail' className="input"></input><br/><p></p>
      <input type="text" name="password" placeholder='Password' className="input"></input><br/>
      <p></p>
      <button class="btn btn-primary">Sign in</button>
     </form>
  </div>
    )
  }
}

export default Login
