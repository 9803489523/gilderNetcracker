import React, {Component} from 'react';
import {Navbar, NavbarBrand} from 'reactstrap';
import {Link} from 'react-router-dom';
import './index.css';
import 'https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js';
import 'https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js';

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return (
            <html>
                <body>
                    <div className="container">
                        <div className="navigation">
                            <ul>
                                <li>
                                    <a href="#">
                                        <span className="icon"><ion-icon name="logo-apple"/></span>
                                        <span className="title">Beautiful project</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span className="icon"><ion-icon name="person-circle-outline"/></span>
                                        <span className="title">Личный кабинет</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span className="icon"><ion-icon name="newspaper-outline"/></span>
                                        <span className="title">Новости</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span className="icon"><ion-icon name="calendar-outline"/></span>
                                        <span className="title">Календарь</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span className="icon"><ion-icon name="game-controller-outline"/></span>
                                        <span className="title">Игра</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="/api/users">
                                        <span className="icon"><ion-icon name="people-outline"/></span>
                                        <span className="title">Пользователи</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="/">
                                        <span className="icon"><ion-icon name="home-outline"/></span>
                                        <span className="title">Домой</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </body>
            </html>
        );
    }
}