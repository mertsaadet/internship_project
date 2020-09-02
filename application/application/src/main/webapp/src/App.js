    import React, {useEffect, useState} from 'react';
import PaginationTable from "./components/table/PaginationTable";
import axios from "axios";
import {Button} from "@material-ui/core";
import PlusIcon from '@material-ui/icons/Add';
import AddButtonDialog from "./components/dialog/AddButtonDialog";
    import DeleteEventDialog from "./components/dialog/DeleteEventDialog";
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

    const addEventDialogFields = [

        {id: "eventName", label: "Name of the Event", type: "text"},
        {id: "longitude", label: "Longitude", type: "number"},
        {id: "latitude", label: "Latitude", type: "number"},
        {id: "eventStartDate", label: "Start Date", type: "text"},
        {id: "eventEndDate", label: "End Date", type: "text"},
        {id: "quota", label: "Quota", type: "number"}

    ];
    const deleteEventDialogField = [{id: "eventName", label:"Type the event you want to delete!", type: "text" }]
    const [tableRows, updateTableRows] = useState([]);

    const [open, setOpen] = React.useState(false);
    const [open2, setOpen2] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };
    const handleClickOpen2 = () => {
        setOpen2(true);
    };
    const handleClose = () => {
        setOpen(false);
    };
    const handleClose2 = () => {
        setOpen2(false);
    };

    useEffect(() => {
        axios.get("/events")
            .then(response => {
                updateTableRows(response.data);
            })
    },[]);



    const onEventAdd = (inputData) => {
      console.log(inputData);
       axios.post("/events", inputData).then( res => {console.log(res);});
        handleClose();
    }
    const onEventDelete = (inputData) => {

        axios.delete("/events/"+inputData.eventName).then(res => {console.log(res)});
        handleClose2();
    }



  return (
    <div className="App">
        <Button variant="contained"
                color="primary"
                style={{float:"right"}}
                onClick={handleClickOpen}
                startIcon={<PlusIcon/>}>Add Event
        </Button>
        <Button variant="contained"
                color="secondary"
                style={{float:"right"}}
                onClick={handleClickOpen2}
                startIcon={<PlusIcon/>}>Delete Event
        </Button>
        <DeleteEventDialog onSubmit={onEventDelete} fields={deleteEventDialogField} open={open2} handleClose={handleClose2}/>
        <AddButtonDialog onSubmit={onEventAdd} fields={addEventDialogFields} open={open} handleClose={handleClose}/>
      <PaginationTable columns={tableColumns} rows={tableRows} />

    </div>
  );
}

export default App;
