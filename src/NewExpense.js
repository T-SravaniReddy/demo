import { render } from '@testing-library/react';
import React, { Component } from 'react'
function NewExpense() {
    const [state,setState]=React.useState({
        id:"",
        date:"",
        description:"",
        Location:"",
        category:""
    });
  
  function handleChange(event) {
    const val=event.target.value;
    setState({
     ...state,
     [event.target.name]:val
    });
  }
  function handleSubmit(event) {
    alert('New Expense is created with Expense ID : ' + state.id + ' on ' + state.date + ' in ' + state.category)
    window.location.href="/new"
  }
    return (
      <div className='center'>
      <h1>Create New Expense</h1>
      <br/>
      <form className="center" onSubmit={handleSubmit}>
      <table>
                <tr>
            <td><label>Expense ID:</label></td>
            <td><input type="text" name="id" value={state.id}  onChange={handleChange} ></input></td>
            </tr>
            <tr>          
            <td><label>Expense Date:  </label></td>
            <td><input type="text" name="date" value={state.date}  onChange={handleChange}></input></td> 
           </tr>
           <tr>
            <td><label>Description:  </label></td>
            <td><input type="text" name="description" value={state.description}  onChange={handleChange}></input></td>
            </tr>
            <tr>
             <td><label>Location:  </label></td>
            <td><input type="text" name="Location" value={state.Location}  onChange={handleChange}></input></td>
            </tr>
            <tr>
             <td><label>Category:  </label></td>
            <td><input type="text" name="category" value={state.category}  onChange={handleChange}></input></td>
            </tr>
            <tr>
            <td></td>
            <td><button>Save</button></td>
            </tr>
            </table>
  </form>
      </div>
    )
  }
  
export default NewExpense
  