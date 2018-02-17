'use strict';

import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import Navigation from './navigation';
import Body from './body';
import Footer from './footer';

class Layout extends Component{

    render(){
        {/* Header Row */}
        return(

            <div className="container-fluid base-layout">

                <Navigation/>

                <div className="row">
                    <div className="col-sm">
                        <Body/>
                    </div>
                </div>


                <Footer/>

            </div>
        );
    }
}

export default Layout;