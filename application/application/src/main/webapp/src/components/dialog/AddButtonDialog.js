import React, {Component} from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';

export default class AddButtonDialog extends Component {

    state = {
        inputData: {}
    }

    handleInputChange = (event) => {
        event.persist();
        console.log(event.target);
        this.setState(prevState => {
            let inputData = {...prevState.inputData};
            inputData[event.target.id] = event.target.value;
            return {inputData};
        })
    }

    render (){
    return (
        <div>

            <Dialog open={this.props.open} onClose={this.props.handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Event Addition</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        To create an event, please fill in the blanks.
                    </DialogContentText>
                    {this.props.fields.map(field => (
                        <TextField
                            autoFocus
                            margin="dense"
                            key={field.id}
                            id={field.id}
                            label={field.label}
                            type={field.type}
                            onChange={this.handleInputChange}
                            fullWidth
                        />
                    ))}
                </DialogContent>
                <DialogActions>
                    <Button onClick={this.props.handleClose} color="primary">
                        Cancel
                    </Button>
                    <Button onClick={() => this.props.onSubmit(this.state.inputData)} color="primary">
                        Add
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );}
}
