import React, { useState } from 'react';

import Sidebar from './components/SideBar/SideBar';
import AssessmentTable from './components/AssessmentTable/AssessmentTable';
import Heading from './components/Header/Header'
import CreateAssessment from './components/CreateAssessment/CreateAssessment'; 
import CreateQuestionSet from './components/CreateSetQuestions/CreateQuestionsSet';
import './App.css';

function App() {
    const [showCreateAssessment, setShowCreateAssessment] = useState(false);
    const [showAddQuestion,setShowAddQuestion] = useState(false);

    const handleCreateAssessmentClick = () => {
        setShowCreateAssessment(true);
    };
    const handleCreateSetQuestionClick = () => {
        setShowAddQuestion(true);

    }

    return (
        <div className="app">
            <Sidebar />
            <div className="content">
                <Heading />

               
                
                {showCreateAssessment ? (
                    <>
                    {showAddQuestion ? 
                    ( <CreateQuestionSet/> )
                    : 
                    (
                    <> <CreateAssessment /> 
                        <button type="submit" onClick={handleCreateSetQuestionClick} >Create Assessment</button>
                        </> )}
                    
                    </>
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
