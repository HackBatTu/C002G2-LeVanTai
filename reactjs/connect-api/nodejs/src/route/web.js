import express from "express";
import homeController from '../controllers/homeController';
import userController from '../controllers/userController';

let router = express.Router();

let initWebRoutes = (app) => {

    // data crud json
    router.get('/', homeController.getHomePage);
    router.get('/crud', homeController.getCRUD);

    router.post('/post-crud', homeController.postCRUD);
    router.get('/get-crud', homeController.displayGetCRUD);
    router.get('/edit-crud', homeController.getEditCRUD);

    router.post('/put-crud', homeController.putCRUD);
    router.get('/delete-crud', homeController.deleteCRUD);


   // api -> font-end
    router.post('/api/login', userController.handleLogin);
    router.get('/api/get-all-users', userController.handleGetAllUsers);
    router.post('/api/create-new-users', userController.handleCreateNewUser);


    return app.use("/", router);
}

module.exports = initWebRoutes;
