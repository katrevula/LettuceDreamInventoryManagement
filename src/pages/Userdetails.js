import { observable, action } from 'mobx';
import React, { Component } from 'react';
import { decorate, flow } from "mobx"
import UserPage from './UserPage';

class Userdetails
 {
  
    fetchAll(){
        this.isLoading=false;
        const response = fetch('http://localhost:8080/api/v1/users');
        const status = response.status;

        if(status == 200)
        {
            this.all = response.json();
        }

    }

    add(data){
        const headers = new Headers();
        headers.append('Content-Type','application/json');

        const options = {
            method: 'POST',
            headers,
            body: JSON.stringify(data),
        };
    const request = new Request('http://localhost:8080/api/v1/users',options);
    const response = fetch(request);
    const status = response.status;
    
    if (status == 201) {
      this.fetchAll();
    }
    if (status === 200) {
      this.isLoading = false;
      this.fetchAll();
    }

    decorate(Userdetails, {
      add: action,
      fetchAll: action
    });

  }
}


export default Userdetails;