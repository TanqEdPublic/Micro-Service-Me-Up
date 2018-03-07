import React from "react";
import {NavLink as Link} from "react-router-dom";

import {
    Navbar,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink } from 'reactstrap';

const GuestPanel = () => (

    <Nav className="ml-auto" navbar>
        <NavItem>
            <NavLink to="/registration" activeClassName="active" tag={Link}>Sign Up</NavLink>
        </NavItem>
        <NavItem>
            <NavLink to="/login" activeClassName="active" tag={Link}>Login</NavLink>
        </NavItem>

    </Nav>

);

const UserPanel = () => (

    <Nav className="ml-auto" navbar>
        <NavItem>
            <NavLink to="/profile" activeClassName="active" tag={Link}>Profile</NavLink>
        </NavItem>

    </Nav>

);

const ServicePanel = () => (
    <Nav className="mr-auto" navbar>
        <NavItem>
            <NavLink to="/services" activeClassName="active" tag={Link}>Services</NavLink>
        </NavItem>
        <NavItem>
            <NavLink to = "/contacts" activeClassName="active" tag={Link}>Contacts</NavLink>
        </NavItem>
    </Nav>


);

// Since React 14, we can write a clean functions instead of classes
// to represent the component.
// We can pass props as a parameter to a function that contains data
// or do distructurisation of it props = {param1, param2, etc}.

function Navigation({authenticated}){
    console.log(authenticated);

    return (
        <Navbar color="dark" dark expand="md">
            <NavbarBrand to="/" tag={Link}>TanqEd Public</NavbarBrand>

            <ServicePanel/>

            { authenticated === true ? <UserPanel/> : <GuestPanel/> }

        </Navbar>
    )
}

export default Navigation;