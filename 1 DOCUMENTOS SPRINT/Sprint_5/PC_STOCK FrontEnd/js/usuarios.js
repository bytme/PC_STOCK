const url = "http://localhost:8080/PC_STOCK/Api/usuarios"
const contenedor = document.querySelector('tbody')
let resultados = ''
const modalUsuarios = new bootstrap.Modal(document.getElementById('modalUsuario'))
const formUsuarios = document.querySelector('form')
const nombreUsuario = document.getElementById('nombre_usu')
const usuarioUsuario = document.getElementById('usuario')
const passwordUsuario = document.getElementById('password')
const emailUsuario = document.getElementById('email')
const tipoUsuario = document.getElementById('codigo_tipo_usu')
const estadoUsuario = document.getElementById('codigo_estado_usu')
const codigoUsuario = document.getElementById('id')

let opcion = ''

btnCrear.addEventListener('click', () => {
    
    nombreUsuario.value = ''
    usuarioUsuario.value = ''
    passwordUsuario.value = ''
    emailUsuario.value = ''
    tipoUsuario.value = ''
    estadoUsuario.value = ''
    codigoUsuario.value = ''
    codigoUsuario.disabled = false
    modalUsuarios.show()
    opcion = 'crear'
})

const ajax = (options) => {
    let { url, method, success, error, data } = options;
    const xhr = new XMLHttpRequest();

    xhr.addEventListener("readystatechange", (e) => {
        if (xhr.readyState !== 4) return;

        if (xhr.status >= 200 && xhr.status < 300) {
            let json = JSON.parse(xhr.responseText);
            success(json);
        } else {
            let message = xhr.statusText || "Ocurrió un error";
            error(`Error ${xhr.status}: ${message}`);
        }
    });

    xhr.open(method || "GET", url);
    xhr.setRequestHeader("Content-type", "application/json; charset=utf-8");
    xhr.send(JSON.stringify(data));
};

const getAll = () => {
    ajax({
        url: url,
        method: "GET",
        success: (res) => {
            console.log(res);

            res.forEach((usuarios) => {
                resultados += `<tr>
                        <td width="10%">${usuarios.codigo_usu}</td>
                        <td width="15%">${usuarios.nombre_usu}</td>
                        <td width="25%">${usuarios.usuario}</td>
                        <td width="25%">${usuarios.password}</td>
                        <td width="25%">${usuarios.email}</td>
                        <td width="25%">${usuarios.codigo_tipo_usu}</td>
                        <td width="25%">${usuarios.codigo_estado_usu}</td>
                        <td class="text-center" width="20%"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                    </tr>`
            });

            contenedor.innerHTML = resultados
        },
        error: (err) => {
            console.log(err);
            $table.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`);
        },
    });
};

document.addEventListener("DOMContentLoaded", getAll);

document.addEventListener("click", (e) => {

    if (e.target.matches(".btnBorrar")) {
        const fila = e.target.parentNode.parentNode
        const id = fila.firstElementChild.innerHTML
        console.log(id)
        alertify.confirm(`Estas seguro de eliminar el id ${id}?`,
            function () {
                ajax({
                    url: url + "/" + id,
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    success: (_res) => location.reload(),
                    error: (err) => alert(err),
                });
                alertify.success('Registro eliminado')
            },
            function () {
                alertify.error('Cancel')
            });


    }
    if (e.target.matches(".btnEditar")) {
        const fila = e.target.parentNode.parentNode
        codigoUsuario.value = fila.children[0].innerHTML
        nombreUsuario.value = fila.children[1].innerHTML
        usuarioUsuario.value = fila.children[2].innerHTML
        passwordUsuario.value = fila.children[3].innerHTML
        emailUsuario.value = fila.children[4].innerHTML
        tipoUsuario.value = fila.children[5].innerHTML
        estadoUsuario.value = fila.children[6].innerHTML
        codigoUsuario.disabled = true
        opcion = 'editar'
        modalUsuarios.show()
    }
})

const fila = e.target.parentNode.parentNode

codigoUsuario.value = fila.children[0].innerHTML

formUsuarios.addEventListener('submit', (e) => {
    e.preventDefault()
    let metodo = "POST"
    if (opcion == 'editar') {
        metodo = "PUT"
 
    }
    ajax({
        url: url,
        method: metodo,
        headers: {
            'Content-Type': 'application/json'
        },
        success: (_res) => location.reload(),
        error: (err) =>
            $form.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`),
        data: {
            "codigo_estado_usu": estadoUsuario.value,
            "codigo_tipo_usu": tipoUsuario.value,
            "codigo_usu": codigoUsuario.value,
            "email": emailUsuario.value,
            "nombre_usu": nombreUsuario.value,
            "password": passwordUsuario.value,
            "usuario": usuarioUsuario.value
            
                },
    });
    modalUsuarios.hide()
})