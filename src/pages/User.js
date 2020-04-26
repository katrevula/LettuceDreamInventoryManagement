import React, { Component } from 'react';


//@observer(['userdetails'])
class User extends React.Component {
  
  render() {
    return (
      <div >
        <h2>
            {this.props.fname} {this.props.lname}
        </h2>
        
      </div>
    );
  }
}

export default User;