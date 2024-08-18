import React, { useState } from 'react';
import './CreateAssessment.css';

const domains = ["AEG", "OD", "CSGT", "DGT"]; // Example domain options

const CreateAssessment = () => {
    const [setName, setSetName] = useState('');
    const [selectedDomain, setSelectedDomain] = useState('');

    const handleSetNameChange = (e) => setSetName(e.target.value);
    const handleDomainChange = (e) => setSelectedDomain(e.target.value);

    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle form submission logic
        console.log("Set Name:", setName);
        console.log("Selected Domain:", selectedDomain);
    };

    return (
        <div className="create-assessment">
            <h2>Create New Assessment</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group-container">
                    <div className="form-group set-name">
                        <label htmlFor="setName">Set Name:</label>
                        <input
                            type="text"
                            id="setName"
                            value={setName}
                            onChange={handleSetNameChange}
                            placeholder="Enter set name"
                            required
                        />
                    </div>
                    <div className="form-group domain">
                        <label htmlFor="domain">Domain Name:</label>
                        <select
                            id="domain"
                            value={selectedDomain}
                            onChange={handleDomainChange}
                            required
                        >
                            <option value="">Select domain</option>
                            {domains.map((domain, index) => (
                                <option key={index} value={domain}>
                                    {domain}
                                </option>
                            ))}
                        </select>
                    </div>
                </div>
                <button type="submit">Create Assessment</button>
            </form>
        </div>
    );
};

export default CreateAssessment;
