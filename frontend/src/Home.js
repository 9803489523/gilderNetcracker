import React, { Component } from 'react';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <html>
                <body>
                    <div>
                        <AppNavbar/>
                        <div className="main">
                            <div className="topbar">
                                <div className="toggle">
                                    <ion-icon name="menu-outline"/>
                                </div>
                                <div className="search">
                                    <label>
                                        <input type="text" placeholder="Search here"/>
                                        <ion-icon name="search-outline"/>
                                    </label>
                                </div>
                                <div className="user">
                                    <img src="/frontend/public/logo192.png" alt="logo"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </body>
            </html>
        );
    }
}
export default Home;