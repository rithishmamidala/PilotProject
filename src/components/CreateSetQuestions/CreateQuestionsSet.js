import React, { useState } from 'react';
import { FaTrashAlt } from 'react-icons/fa'; // Importing a delete icon from react-icons

// Sample data for the table
const initialData = [
    { id: 1, question: 'What is React?', explore: 'Learn more', edit: 'Edit' },
    { id: 2, question: 'What is JSX?', explore: 'Learn more', edit: 'Edit' },
    { id: 3, question: 'What is a component?', explore: 'Learn more', edit: 'Edit' },
];

function CreateQuestionSet() {
    const [data, setData] = useState(initialData);
    const [editingId, setEditingId] = useState(null);
    const [editValue, setEditValue] = useState('');
    const [newQuestion, setNewQuestion] = useState('');
    const [addingNew, setAddingNew] = useState(false);

    // Handle the edit button click
    const handleEditClick = (id, currentQuestion) => {
        setEditingId(id);
        setEditValue(currentQuestion);
    };

    // Handle the save button click
    const handleSaveClick = (id) => {
        setData(data.map(item =>
            item.id === id ? { ...item, question: editValue } : item
        ));
        setEditingId(null);
        setEditValue('');
    };

    // Handle the cancel button click
    const handleCancelClick = () => {
        setEditingId(null);
        setEditValue('');
    };

    // Handle the delete icon click (no action needed)
    const handleDeleteClick = (id) => {
        // This function can be empty or handle no action
    };

    // Start adding a new question
    const handleAddQuestionClick = () => {
        setAddingNew(true);
    };

    // Handle new question submission
    const handleNewQuestionSubmit = () => {
        if (newQuestion.trim() === '') return; // Don't add if empty

        const newId = data.length ? Math.max(data.map(item => item.id)) + 1 : 1;
        setData([...data, { id: newId, question: newQuestion, explore: 'Learn more', edit: 'Edit' }]);
        setNewQuestion('');
        setAddingNew(false);
    };

    // Handle new question input change
    const handleNewQuestionChange = (e) => {
        setNewQuestion(e.target.value);
    };

    // Cancel adding a new question
    const handleCancelAddClick = () => {
        setNewQuestion('');
        setAddingNew(false);
    };

    return (
        <div>
            <h1>Questions Table</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Sr. No.</th>
                        <th>Question</th>
                        <th>Explore</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((item, index) => (
                        <tr key={item.id}>
                            <td>{index + 1}</td>
                            <td>
                                {editingId === item.id ? (
                                    <input
                                        type="text"
                                        value={editValue}
                                        onChange={(e) => setEditValue(e.target.value)}
                                    />
                                ) : (
                                    item.question
                                )}
                            </td>
                            <td>
                                <button>Explore</button> {/* Button labeled "Explore" */}
                            </td>
                            <td>
                                {editingId === item.id ? (
                                    <>
                                        <button onClick={() => handleSaveClick(item.id)}>Save</button> {/* Save button */}
                                        <button onClick={handleCancelClick}>Cancel</button> {/* Cancel button */}
                                    </>
                                ) : (
                                    <button onClick={() => handleDeleteClick(item.id)}>
                                        <FaTrashAlt /> {/* Delete icon button */}
                                    </button>
                                )}
                            </td>
                        </tr>
                    ))}
                    {addingNew && (
                        <tr>
                            <td>{data.length + 1}</td>
                            <td>
                                <input
                                    type="text"
                                    value={newQuestion}
                                    onChange={handleNewQuestionChange}
                                    placeholder="Enter new question"
                                />
                            </td>
                            <td colSpan="2">
                                <button onClick={handleNewQuestionSubmit}>Submit</button> {/* Submit button */}
                                <button onClick={handleCancelAddClick}>Cancel</button> {/* Cancel button */}
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>
            {!addingNew && (
                <div>
                    <button onClick={handleAddQuestionClick}>Add Question</button> {/* Add Question button */}
                </div>
            )}
        </div>
    );
}

export default CreateQuestionSet;
