import './header.css'

function Header(props){

    return(
        <div className="header">
            <i className={props.icone}></i> {props.title}
        </div>
    )
}export default Header;