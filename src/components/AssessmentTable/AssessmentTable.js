import React,{useEffect,useState} from 'react';
import './AssessmentTable.css';


import {EList}  from '../../Service/EmployeeService';




const AssessmentTable = () => {
    

let [assessments,getAssessments] = useState([]);

    useEffect(()=>{
        EList().then((res) => {
            getAssessments(res.data);

        }).catch(()=>{
            alert("Something Went Wrong");

        });
  
    },[])
    console.log(assessments);
    return (
        <div className="assessment-table">
         
            <table>
                <thead>
                    <tr>
                        <th>SRL No</th>
                        <th>Set Name</th>
                        <th>Created By</th>
                        <th>Domain</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {assessments.map((assessment) => (
                        <tr key={assessment.srlNo}>
                            <td>{assessment.srlNo}</td>
                            <td>{assessment.setName}</td>
                            <td>{assessment.createdBy}</td>
                            <td>{assessment.domain}</td>
                            <td>
                                <span className={`status ${assessment.status.toLowerCase()}`}>
                                    {assessment.status}
                                </span>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            
        </div>
    );
};

export default AssessmentTable;
