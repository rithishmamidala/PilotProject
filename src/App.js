
import React, { useState } from 'react';

import Sidebar from './components/SideBar/SideBar';


import AssessmentTable from './components/AssessmentTable/AssessmentTable';

import Heading from './components/Header/Header'

import CreateAssessment from './components/CreateAssessment/CreateAssessment'; 

import './App.css';

function App() {
    const [showCreateAssessment, setShowCreateAssessment] = useState(false);

    const handleCreateAssessmentClick = () => {
        setShowCreateAssessment(true);
    };

    return (
        <div className="app">
            <Sidebar />
            <div className="content">
                <Heading />
                {showCreateAssessment ? (
                    <CreateAssessment /> // Display component when button is clicked
                ) : (
                    <>
                        <AssessmentTable />
                        <button onClick={handleCreateAssessmentClick}>
                            Create New Assessment
                        </button>
                    </>
                )}
            </div>
        </div>
    );
}

export default App;
