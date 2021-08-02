const url = 'http://ec2-18-224-179-88.us-east-2.compute.amazonaws.com:8090';


function fetchAll() {
    $.get(url + "/fetchAllUsers", function (response) {
        let users = response;
        let usersTemplateHTML = "";
        for (let i = 0; i < users.length; i++) {
            usersTemplateHTML = usersTemplateHTML + 
                '                <img src="img/tete.jpg" width="55px" height="55px" alt="avatar" />\n' +
                '                <div class="about">\n' +
                '                    <div id="PrenomAppender_' + users[i].id + '" class="name">' + users[i].prenom + '</div>\n' +
                '                    <div class="status">\n' +
                '                        <i class="fa fa-circle offline"></i>\n' +
                '                    </div>\n' +
                '                </div>\n';
        }
        $('#usersList').html(usersTemplateHTML);
    });
}
