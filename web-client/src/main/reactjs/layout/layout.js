'use strict';

import React, { Component } from 'react';

import { Grid, Row, Col} from 'react-bootstrap';

import Header from './header';
import Body from './body';
import Footer from './footer';

class Layout extends Component{

    render(){
        {/* Header Row */}
        return(

            <Grid>
            {/* Main Grid of the Web Page. Defines layout, global style, ... */}
                <Col>

                    {/* Header Row */}
                    <Row>
                        <Header/>
                    </Row>

                    {/* Body Row */}
                    <Row>
                        <Body/>
                    </Row>

                    {/* Footer Row */}
                    <Row>
                        <Footer/>
                    </Row>
                </Col>

            </Grid>
        );
    }
}

export default Layout;