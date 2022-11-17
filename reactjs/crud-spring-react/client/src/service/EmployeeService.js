import axios from 'axios'

const URL_DATABASE = "http://localhost:8080/api"


class EmployeeService {
    getEmployee(){
        return axios.get(URL_DATABASE + "/list");
    }

    createEmployee(employee){
        return axios.post(URL_DATABASE + "/create" , employee);
    }

    editEmployee(employee){
        return axios.put(URL_DATABASE + "/edit", employee);
    }

    detailsEmployee(id){
        return axios.get(URL_DATABASE + "/findById/" + id);
    }

    deleteEmployee(id){
        return axios.delete(URL_DATABASE + "/delete/" + id);
    }

}

export default new EmployeeService();