import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import './App.css'

class UserList extends Component {

    constructor(props) {
        super(props);
        this.state = {users: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/users')
            .then(response => response.json())
            .then(data => this.setState({users: data}));
    }

    async remove(id) {
        await fetch('/api/users/${id}', {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedUsers = [...this.state.users].filter(i => i.id !== id);
            this.setState({users: updatedUsers});
        });
    }

    render() {
        const {users, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const userList = users.map(user => {
            return <tr key={user.id}>
                <td style={{whiteSpace: 'nowrap'}}>{user.id}</td>
                <td>{user.username}</td>
                <td>{user.email}</td>
                <td>{user.enabled}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/api/users/" + user.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(user.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <body>
                <div><AppNavbar/></div>
                <div className="main">
                    <div className="details">
                        <div className="recentUsers">
                            <div className="cardHeader">
                                <h2>Recent Users</h2>
                                <a href="#" className="btn">View All</a>
                                <Button color="success" tag={Link} to="/api/users/new">Add User</Button>
                            </div>
                            <table>
                                <thead>
                                    <tr>
                                        <td>ID</td>
                                        <td>Username</td>
                                        <td>Email</td>
                                        <td>Enabled?</td>
                                        <td>Actions</td>
                                    </tr>
                                </thead>
                                <tbody>
                                {userList}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </body>
        );
    }
}
export default UserList;