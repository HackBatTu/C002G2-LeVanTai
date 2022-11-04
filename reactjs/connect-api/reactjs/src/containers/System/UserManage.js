import React, { Component } from 'react';
import { FormattedMessage } from 'react-intl';
import { connect } from 'react-redux';
import './UserManage.scss'
import { getAllUsers } from '../../services/userService'
class UserManage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            arrUsers: []
        }
    }

    async componentDidMount() {
        let response = await getAllUsers('ALL');
        console.log(response)
        if (response && response.errCode === 0) {
            this.setState({
                arrUsers: response.users
            })
        }
    }

    /**vòng đời
     * Run components
     * 1. run construct -> init state
     * 2. Did mount (set state)
     * 3.render
     */
    render() {
        let arrUsers = this.state.arrUsers;
        console.log(arrUsers)
        return (
            <div className="users-container">
                <div className="title text"> Manager</div>
                <div>
                    <table id="customers">
                    <thead className="thead-dark">
                        <tr>
                            <th>Email</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Address</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        { arrUsers && arrUsers.map((item, index) => {
                            console.log('check = ' ,item,index)
                            return ( 
                             <tr>
                                <td>{item.email}</td>
                                <td>{item.lastName}</td>
                                <td>{item.firstName}</td>
                                <td>{item.address}</td>
                                <td>
                                    <button className="btn-edit"><i className="fas fa-pencil-alt"></i></button>
                                    <button className="btn-delete"><i className="fas fa-frash"></i></button>
                                </td>
                            </tr>
                            )
                        })}
                        </tbody>
                    </table>

                </div>
            </div>
        );
    }

}

const mapStateToProps = state => {
    return {
    };
};

const mapDispatchToProps = dispatch => {
    return {
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(UserManage);
