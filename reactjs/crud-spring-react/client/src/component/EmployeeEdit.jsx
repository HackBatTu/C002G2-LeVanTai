import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import EmployeeService from '../service/EmployeeService';

const EmployeeEdit = () => {
    const [id, setId] = useState("");
    const [email, setEmail] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [active, setActive] = useState(true);
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        const employee = { email, firstName, lastName, active }
        EmployeeService.createEmployee(employee).then((res) => {

            navigate('/')
        })
    }

    return (
        <div>
            <h1 className="text-center text-primary mb-5 "> EmployeeCreate</h1>
            <form className="container" onSubmit={handleSubmit}>
            <div className="col-12 form-group">
                    <label>Id</label>
                    <input value={id} onChange={e => setId(e.target.value)} className="form-control"></input>
                </div>
                <div className="col-12 form-group">
                    <label>Email</label>
                    <input value={email} onChange={e => setEmail(e.target.value)} className="form-control"></input>
                </div>
                <div className="col-12 form-group">
                    <label>firstName</label>
                    <input value={firstName} onChange={e => setFirstName(e.target.value)} className="form-control"></input>
                </div>
                <div className="col-12 form-group">
                    <label>lastName</label>
                    <input value={lastName} onChange={e => setLastName(e.target.value)} className="form-control"></input>
                </div>
                <div className="col-12 form-check">
                    <input checked={active} onChange={e => setActive(e.target.checked)} type="checkbox" className="form-check-input"></input>
                    <label className="form-check-lable">Is Active</label>
                </div>
                <div className="col-12">
                    <div className="form-group">
                        <button className="btn btn-success" type="submit" >Save</button>
                        <Link className="btn btn-danger" to="/">Back</Link>
                    </div>

                </div>
            </form>


        </div>
    );

}

export default EmployeeEdit;