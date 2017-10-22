var modalLoginVM = new Vue({
    el: '#modal-login',
    data: {
        state: false,
        cellphone: {value: '', msg: '', state: 0},
        password: {value: '', msg: '', state: 0}
    },
    methods: {
        loginSubmit: function () {
            this.state = true;
            var data = [this.cellphone, this.password];
            if(data[0].state === 1 && data[1].state === 1) {
                axios.post('',{ cellphone:data[0].value, password: data[1].value }).then(function (res) {
                    if (res.data.state === -1) {
                        data[0].state = -1;
                        data[0].msg = '手机号码未注册';
                    } else if (res.data.state === 0) {
                        data[1].state = -1;
                        data[1].msg = '密码错误';
                    } else if (res.data.state === 1) {
                        console.log("登录成功");
                    }
                }, function (res) {
                    console.log("服务器未响应");
                })
            }
            for (var i in data) {
                if (data[i].value === '') {
                    data[i].state = -1;
                    data[i].msg = '不能为空';
                }
            }
            this.state = false;
        },
        clear: function () {
            this.state = false;
            this.cellphone = {value: '', msg: '', state: 0};
            this.password = {value: '', msg: '', state: 0};
        }
    },
    watch: {
        'cellphone.value': function () {
            var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
            var match = pattern.test(this.cellphone.value);
            if (match) {
                this.cellphone.state = 1;
                this.cellphone.msg = '';
            } else if (!match && this.cellphone.value !== '') {
                this.cellphone.state = -1;
                this.cellphone.msg = '格式错误';
            } else {
                this.cellphone.state = 0;
                this.cellphone.msg = '';
            }
        },
        'password.value': function () {
            if (this.password.value) {
                this.password.state = 1;
                this.password.msg = '';
            } else {
                this.password.state = 0;
                this.password.msg = ''
            }
        }
    }
});
var modalSignUpVM = new Vue({
    el: '#modal-signup',
    data: {
        state: false,
        cellphone: {value: '', msg: '', state: 0},
        password: {value: '', msg: '', state: 0},
        confirm: {value: '', msg: '', state: 0}
    },
    methods: {
        signUpSubmit: function () {
            this.state = true;
            var data = [this.cellphone, this.password, this.confirm];
            if (data[0].state === 1 && data[1].state === 1 && data[2].state === 1) {
                axios.post('',{ cellphone: data[0].value, password: data[1].value }).then(function(res) {
                    if (res.data.state === -1) {
                        data[0].state = -1;
                        data[0].msg = '手机号码已注册';
                    } else {
                        console.log("注册成功");
                    }
                }, function(res) {
                    console.log("服务器未响应");
                })
            }
            for (var i in data) {
                if (data[i].value === '') {
                    data[i].state = -1;
                    data[i].msg = '不能为空';
                }
            }
            this.state = false;
        },
        clear: function () {
            this.state = false;
            this.cellphone = {value: '', msg: '', state: 0};
            this.password = {value: '', msg: '', state: 0};
            this.confirm = {value: '', msg: '', state: 0};
        }
    },
    watch: {
        'cellphone.value': function () {
            var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
            var match = pattern.test(this.cellphone.value);
            if (match) {
                this.cellphone.state = 1;
                this.cellphone.msg = '';
            } else if (!match && this.cellphone.value !== '') {
                this.cellphone.state = -1;
                this.cellphone.msg = '格式错误';
            } else {
                this.cellphone.state = 0;
                this.cellphone.msg = '';
            }
        },
        'password.value': function () {
            var pattern = /^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\W_]+$)(?![a-z0-9]+$)(?![a-z\W_]+$)(?![0-9\W_]+$)[a-zA-Z0-9\W_]{8,}$/;
            var match = pattern.test(this.password.value);
            if (match) {
                this.password.state = 1;
                this.password.msg = '';
            } else if (!match && this.password.value !== '') {
                this.password.state = -1;
                this.password.msg = '格式错误';
            } else {
                this.password.state = 0;
                this.password.msg = ''
            }
        },
        'confirm.value': function () {
            var match = (this.confirm.value === this.password.value);
            if (match) {
                this.confirm.state = 1;
                this.confirm.msg = '';
            } else if (!match && this.confirm.value !== ''){
                this.confirm.state = -1;
                this.confirm.msg = '两次密码不一致';
            } else {
                this.confirm.state = 0;
                this.confirm.msg = '';
            }
        }
    }
});
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})