import logo from './logo.svg';
import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import EmployeeList from './component/EmployeeList';
import EmployeeCreate from './component/EmployeeCreate';
import EmployeeEdit from './component/EmployeeEdit';
import EmployeeDetails from './component/EmployeeDetails';
import HeaderComponent from './component/HeaderComponent';
import FooterComponent from './component/FooterComponent';


function App() {
  return (
    
      <BrowserRouter>
          <HeaderComponent />
          <div className="container">
            <Routes>
              <Route path="/" element={<EmployeeList />} />
              <Route path="/employees" element={<EmployeeList />} />
              <Route path="/add-employee" element={<EmployeeCreate />} />
              <Route path="/edit/:id" element={<EmployeeEdit />} />
              <Route path="/details/:id" element={<EmployeeDetails />} />
            </Routes>
          </div>
          <FooterComponent />
      </BrowserRouter>
    
  );
}
export default App;
