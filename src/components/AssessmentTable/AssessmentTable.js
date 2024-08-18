import React from 'react';
import './AssessmentTable.css';

const assessments = [
    { id: 1, name: "CodeLink", creator: "Arijit", domain: "AEG", status: "Approved" },
    { id: 2, name: "ByteBundle", creator: "Hemanth", domain: "OD", status: "Pending" },
    { id: 3, name: "TechTribe", creator: "Vasantha", domain: "CSGT", status: "Approved" },
    { id: 4, name: "DataDuo", creator: "Brahmaiah", domain: "DGT", status: "Approved" },
    { id: 5, name: "CodeClique", creator: "nitish", domain: "CSGT", status: "Pending" },
    { id: 6, name: "DataHub", creator: "Ragini", domain: "AEG", status: "Pending" },
    { id: 7, name: "TechSync", creator: "Neha", domain: "OD", status: "Pending" },
];

const AssessmentTable = () => {
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
                        <tr key={assessment.id}>
                            <td>{assessment.id}</td>
                            <td>{assessment.name}</td>
                            <td>{assessment.creator}</td>
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
