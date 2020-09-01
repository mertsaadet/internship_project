import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TablePagination from '@material-ui/core/TablePagination';
import TableRow from '@material-ui/core/TableRow';
import TableHeader from "./TableHeader";
import TableContent from "./TableContent";

const columns = [
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
    }
];



const rows = [
];

const useStyles = makeStyles({
    root: {
        width: '100%',
    },
    container: {
        maxHeight: 440,
    },
});

export default function PaginationTable() {
    const classes = useStyles();
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(10);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };

    return (
        <Paper className={classes.root}>
            <TableContainer className={classes.container}>
                <Table stickyHeader aria-label="sticky table">
                    <TableHeader columns={columns}/>
                    <TableContent columns={columns} rows={rows} page={page} rowsPerPage={rowsPerPage}/>
                </Table>
            </TableContainer>
            <TablePagination
                rowsPerPageOptions={[10, 25, 100]}
                component="div"
                count={rows.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onChangePage={handleChangePage}
                onChangeRowsPerPage={handleChangeRowsPerPage}
            />
        </Paper>
    );
}
