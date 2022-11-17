import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';
import { Link, redirect, useNavigate } from 'react-router-dom'

class EmployeeList extends Component {

    constructor(props) {
        super(props)
        this.state = {
            employee: []
        }
    }

    componentDidMount() {
        EmployeeService.getEmployee().then((res) => {
            this.setState({
                employee: res.data
            })
        })
    }

    RemoveO = (id) => {
        EmployeeService.deleteEmployee(id).then((res) => {
            redirect("/")
        })
    }

    render() {
        return (
            <div>
                <h1 className="text-center mb-5 mt-5 text-primary">Employee Management</h1>
                <div className="row">
                    <button className="btn btn-primary w-25 mb-3" >
                        <Link to='/add-employee' className='nav-link'>Create Employee (+)</Link>
                    </button>
                </div>
            
                <div className="row">
                    <table className="table table-hover table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Email</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th className="text-center">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.employee.map(
                                    employee =>
                                        <tr key={employee.id}>
                                            <td className="align-middle">{employee.id}</td>
                                            <td className="align-middle">{employee.email}</td>
                                            <td className="align-middle">{employee.firstName}</td>
                                            <td className="align-middle">{employee.lastName}</td>
                                            <td className="align-middle text-center">
                                                <button className="btn btn-primary pr-5"><Link to={`/details-employee/${employee.id}`} className='nav-link'>Details</Link></button>
                                                <button className="btn btn-warning pr-2"><Link to={`/edit-employee/${employee.id}`} className='nav-link'>Edit</Link></button>
                                                <a onClick={() => { this.RemoveO(employee.id) }} className="btn btn-danger">Delete</a>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default EmployeeList;