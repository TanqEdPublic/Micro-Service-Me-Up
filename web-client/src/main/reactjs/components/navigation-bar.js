import React from "react";
import {NavLink as Link} from "react-router-dom";

import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    Row,
    Col} from 'reactstrap';

const UserPanel = () => (

    <Nav className="ml-auto mr-auto" navbar>
        <NavItem>
            <NavLink to="/registration" activeClassName="active" tag={Link}>Sign Up</NavLink>
        </NavItem>
        <NavItem>
            <NavLink to="/login" activeClassName="active" tag={Link}>Login</NavLink>
        </NavItem>
    </Nav>

);

const ServicePanel = () => (
    <Nav className="ml-auto mr-auto" navbar>
        <NavItem>
            <NavLink to="/services" activeClassName="active" tag={Link}>Services</NavLink>
        </NavItem>
        <NavItem>
            <NavLink to = "/contacts" activeClassName="active" tag={Link}>Contacts</NavLink>
        </NavItem>
    </Nav>


);

class Navigation extends React.Component {
    constructor(props) {
        super(props);

        this.toggle = this.toggle.bind(this);
        this.state = {
            isOpen: false
        };
    }
    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }
    render() {
        return (
            <Navbar color="dark" dark expand="md">
                <NavbarBrand to="/" tag={Link}>TanqEd Public</NavbarBrand>

                <NavbarToggler onClick={this.toggle} />
                <Collapse isOpen={this.state.isOpen} navbar>

                    <Nav className="ml-auto mr-auto" navbar>

                        <NavItem>
                            <NavLink to="/services" activeClassName="active" tag={Link}>Services</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink to = "/contacts" activeClassName="active" tag={Link}>Contacts</NavLink>
                        </NavItem>


                        <NavItem>
                            <NavLink to="/registration" activeClassName="active" tag={Link}>Sign Up</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink to="/login" activeClassName="active" tag={Link}>Login</NavLink>
                        </NavItem>

                    </Nav>

                </Collapse>
            </Navbar>
        )
    }
}

export default Navigation;