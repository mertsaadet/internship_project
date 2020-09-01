import React, {useEffect, useState} from 'react';
import PaginationTable from "./components/table/PaginationTable";
import axios from "axios";
import {Button} from "@material-ui/core";
import PlusIcon from '@material-ui/icons/Add';
function App() {

    const tableColumns = [
        { id: 'eventName', label: 'Event Name', minWidth: 170 },
        { id: 'longitude', label: 'Longitude', minWidth: 100 },
        {
            id: 'latitude',
            label: 'Latitude',
            minWidth: 170,
            align: 'right',
        },
        {
            id: 'eventStartDate',
            label: 'Event Start Date',
            minWidth: 170,
            align: 'right',
        },
        {
            id: 'eventEndDate',
            label: 'Event End Date',
            minWidth: 170,
            align: 'right',
        },
        {
            id: 'quota',
            label: 'Quota',
            minWidth: 170,
            align: 'right',
        },
    ];

    const [tableRows, updateTableRows] = useState([]);



    useEffect(() => {
        axios.get("/events")
            .then(response => {
                updateTableRows(response.data);
            })
    },[]);

  return (
    <div className="App">
        <Button variant="contained"
                color="primary"
                style={{float:"right"}}
                startIcon={<PlusIcon/>}>Add Event</Button>

      <PaginationTable columns={tableColumns} rows={tableRows} />

    </div>
  );
}

export default App;
