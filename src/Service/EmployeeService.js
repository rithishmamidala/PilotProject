import axios from 'axios';

const employeeList_URL = `http://localhost:9098/admin`; 

 const EList = () => axios.get(employeeList_URL+"/retrive");

//  const PList= () => axios.post(employeeList_URL+"/add",  {
//     setName: "CodeLink",
//     createdBy: "VISHU",
//     domain: "AEG",
//     status: "PENDING"});

//         PList().then((res)=>{
//             console.log("data posted");
//         }).catch(()=>{
//         alert("some thing went wrong!")});
    

 export  {EList};