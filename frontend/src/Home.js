import React, { Component } from 'react';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import {Button, ButtonGroup, Container} from 'reactstrap';
import logo from './public/logo192.png';

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {users_stat: []};
    }

    componentDidMount() {
        fetch('/api/users/statistics')
            .then(response => response.json())
            .then(data => this.setState({users_stat: data}));
    }

    render() {

        const {users_stat} = this.state;
        users_stat.map(user_stat => {
            return <tr key={user_stat.id}>
                <td>{user_stat.hours}</td>
                <td>{user_stat.count_of_exercise_performed}</td>
                <td>{user_stat.day}</td>
            </tr>
        });

        function selectUserStatH(id) {
            Home.id = id;
            return hours;
        }

        const hours = users_stat.map(user_stat => {
            if (user_stat.user.id === Home.id)
                return <td>{user_stat.hours}</td>

        });

        function selectUserStatC(id) {
            Home.id = id;
            return exercise;
        }

        const exercise = users_stat.map(user_stat => {
            if (user_stat.user.id === Home.id)
                return <td>{user_stat.count_of_exercises_performed}</td>

        });

        function selectUserStatD(id) {
            Home.id = id;
            return date;
        }

        const date = users_stat.map(user_stat => {
            if (user_stat.user.id === Home.id)
                return <td>{user_stat.day}</td>

        });

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
                                    <img src={logo}/>
                                </div>
                            </div>

                            <div className="cardBox">
                                <div className="card">
                                    <div>
                                        <div className="numbers">{selectUserStatH(4)}</div>
                                        <div className="cardName">Hours</div>
                                    </div>
                                    <div className="iconBx">
                                        <ion-icon name="hourglass-outline"/>
                                    </div>
                                </div>
                                <div className="card">
                                    <div>
                                        <div className="numbers">{selectUserStatC(4)}</div>
                                        <div className="cardName">Count of exercises performed</div>
                                    </div>
                                    <div className="iconBx">
                                        <ion-icon name="barbell-outline"/>
                                    </div>
                                </div>
                                <div className="card">
                                    <div>
                                        <div className="numbers">{selectUserStatD(4)}</div>
                                        <div className="cardName">Date</div>
                                    </div>
                                    <div className="iconBx">
                                        <ion-icon name="calendar-outline"/>
                                    </div>
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