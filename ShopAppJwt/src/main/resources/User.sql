INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (1, 'admin1', '$2a$10$mjRa7yW5.FBw5gJ2z6Wdj.8pY1s36HMTnz3CHI8EZIYjfoVdJ8IAG', 'adminadmin@admin.com', true), (2, 'staff1', '$2a$10$eAtaHjH7hrv/oM4.QWbHOOeenW.n4FvTv.eIRlkUadqdrCGFwtIve', 'staff2staff2@staff2.com', true), (3, 'user1', '$2a$10$d0gaAa84bEEIYhXRdUmKx.nXdrBmf0Xyb.oG9AKSUO6v.7Gqlx6g2', 'user1user1@user1.com', true);

INSERT INTO sys_role (role_id, role) VALUE (1, 'ADMIN'), (2, 'STAFF'), (3, 'USER');

INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (1, 1), (2, 2), (3, 3);

INSERT INTO sys_url (url_id, url) VALUE (1, '/admin'), (2, '/member'), (3, '/user/change/pwd'), (4, '/admin/read/**'), (5, '/admin/create/**'), (6, '/admin/update/**'), (7, '/admin/delete/**'), (8, '/jwt/inspect/**');

INSERT INTO sys_url_role (from_url_id, from_role_id) VALUE (1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (7, 1), (8, 1), (2, 2), (3, 2), (4, 2),  (5, 2),  (6, 2), (2, 3), (3, 3);








INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (4,'e6fd3ab3-cc89-4abb-a589-784aa53beb5c','$2a$10$czOD/OLEqc1v10.LZL678.yKtzmPzNVwtLsSYpbuKouiGTnrYP4q2','fcf46950-701e-49e2-acd6-25cef10e09c8@9cab683f-4a54-4f3e-a012-bccd7bbbd4af.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (5,'8a5d83b9-3f6d-44aa-8289-afe36b4717f7','$2a$10$A3.aVAiMNyxxpYbCOM5n7eAzeLeDDt009BiJlUSriQoiSWwA3wyTG','4eb5b96c-4a49-438a-a737-4754f7c5f8e0@2165f222-6e7f-417c-a06d-c99b73492ccc.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (6,'bc41812c-76fa-4dc8-a2d4-03aeb1f74985','$2a$10$P5Pev7mDFv7qAGV9TE8XJ.2LHYxRMflhXToX8O1im2mvcmxJXTVsi','9f7819ab-c1ed-4683-89e0-e4b2125bafb8@1fb0fc24-3b35-4c22-97a6-5bf01db10ea1.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (7,'648f502b-43cc-40e4-85ff-2934736bf892','$2a$10$qoaFxsrT91jNlf9lsi5TRe0lUVfl5tsspd.hH5tbryYKuZF.eASBW','f291cbc7-0e57-4861-8044-e7fef1006448@9e53bb53-8c82-452c-89b1-027ed989afcb.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (8,'7bacf504-8c37-419e-bcd7-b33630b4e629','$2a$10$2.drsHYV9vr4kU8bGWa/kexEPkqfYFv0t7ewmsjWAAANVrY.J6/xa','816aca79-9e00-4671-a6c0-2085e3ef6adb@aa68b27c-2a05-41b7-a280-2d35c239a1b3.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (9,'fffab431-c19b-46d2-b902-2546dcf6d7eb','$2a$10$XVWgIvjrZPDNxgQ2sdMajuFAPrJFNXaRyNDy5YCQDfla/R.Q/tc0O','c8720788-676c-4353-bef5-c00437fb2cb1@e46aa0c5-cfee-406d-b9a5-7dcdbb186d35.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (10,'0fd4ca03-0b5d-4882-8b1d-d85ec0634b58','$2a$10$RBS4DL7jYyT6PJjDqtaJlOtrqfVQu1nMI0s7sX1XCv3PrN4qe17VO','52f6ed9f-2e3d-484d-a0cd-522609a8c787@a24a4a5c-52f6-469e-a891-2852c936165d.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (11,'7ec6df2e-72d6-45e1-8868-f7e94b4adba8','$2a$10$EeoOEMwpNIofGPWKD2sLt.P0DHFlS46Tq3XZmkOb0JPHAIMH9XDs2','4ca29814-1e78-4057-a673-114aae825d80@b0b37465-46d4-421d-bf3c-905f2cf2fa72.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (12,'3cb947c5-50fa-4814-80e2-3589ac446ac8','$2a$10$DnIV3kAApbTsO/5rvYlIS.ahZdL7D/epJRoxoucAaq9hFYr4w8BfG','de2a3e09-d6f7-4e21-9819-0271e5c3825c@5fdb5c00-fb20-4855-aa2e-76d01ce7f9f9.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (13,'d1d4b0e2-644f-41fd-a84a-75165cfe4afd','$2a$10$C9TJnjNP9ctsgAAb3x.YauH7vSh3MnmRN2Efdn8bIvYzN6Pj8YT22','f45a692b-1b47-4533-9a19-0665e1d08811@472678df-5705-435f-b817-266551e64be8.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (14,'1d0f45fc-1e64-4544-8798-357d30fc4de2','$2a$10$FXoEPtyhy7C.ZEMvtXVrUOerzjTT0NnZCubDQ6r1K5fLkTTnlCkyS','90735d73-a6c6-4d61-8e84-522554747ea3@80b03131-f948-4a41-b791-bf2e32085b9b.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (15,'3fa1d3c3-bedf-4482-9cbd-50971f605bae','$2a$10$gTHx5/.3EsxEaRHXXT0YXOeJsHeASZhQZf8hriRFWMyKcWy2G.0dm','3164e40b-bbf0-4168-9da3-158593fd5ece@472e9140-6b79-4a63-8453-a196a0e11bd5.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (16,'8c6cf1b8-60b0-432b-8cf9-2028dc2880fc','$2a$10$SK3AwCe94x2X8CwGZ1SjnOJ.EiH9EpJr.CnDyy8RjisQoCeY1oxde','02992874-7265-4392-a5a5-2183d700fade@b8cac319-7859-4044-a2d2-fe45a6a8668f.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (17,'c84d7389-d94a-4794-92f5-79406e9d022c','$2a$10$b9.NDc4MvrrE0NlhL1P//OtGOc488GrvbwbOrqe0X7LIi5cnntCK.','682de381-59e1-492e-b2de-005d3b71411c@4ae58796-9b19-4455-a972-a926951ce394.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (18,'ec08972a-5c52-418f-9dfd-004e6161e906','$2a$10$d7epWbH9euVdgG1vwtVWCO6VOx7t3KfoO.Zdi1SICB8vJSFZu6a6W','eb816df1-0eaa-466c-a0d8-e2936bd9c404@fbfa2b18-d026-4de2-88cf-c909b6e9faa8.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (19,'9e251d92-2e14-4e2e-bf7b-e1e3da4f01cc','$2a$10$5sFiGG8hVYmq9B8dY.ZtmeQZbkiSAfJgOYEpsHAl2EIaRe6DDn7Mq','51ed50f5-3f0a-4514-8dd4-d10afd49b6cb@c3a20a77-fcf7-4696-890c-06cb01ffb546.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (20,'4e19ccde-ae77-4dcd-8d8e-0321e3ee787b','$2a$10$uMv7RCAn0ZcT6JoCPCBXsel8yLFd2BLhPHguR5le3.Ul9.FlydKYC','e9e5c0f7-7228-40c2-8e99-ed35f1e1a3e5@23c99d10-0e79-4ae7-a3b1-db6ba4b1beee.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (21,'d6e7b2fa-347b-4d3b-8dae-978985be5ed5','$2a$10$wBD5SQs3uWBIopRLT6REiOAO851cVTjN.feBCwlTw.h.odUcMgMNi','ebe11dcc-717d-4659-9d1e-e4a142accd98@823ed569-4d7b-456b-a846-0338d788121a.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (22,'07dea95a-3372-437d-bc8c-f6169b4cc994','$2a$10$yCHR61U4t0Dl1RTcfFMieurX0094MhbnupX1QQY8sKYDJc6UwqZum','5e67f8ba-1c06-4072-be03-b05afe2357ad@3fb3a2c0-dbdf-4b31-97f4-53f6bb8175a8.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (23,'6dca8d34-3c1c-4286-90f7-ba2de6350d04','$2a$10$NF8Ev27bMAPk.niafP194O2tMHMhRPOZrgU5kwaFO45zrmcXBYZki','0c57cb1c-f41b-460a-91a9-a8979d7ce873@8b95a52a-a146-4e4d-ba4f-83e34e5d1665.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (24,'9e9359cc-870f-4302-8496-d2b9607264d8','$2a$10$LmICHy/.FHxJum53HxVF5O0qMAqDrb1Ci7xpokIXaKCUlL/nfX/k.','2f25ab4a-e6e0-4af2-9ebc-c102af21b2a8@d4ac7a3b-4724-439e-8438-f088f707838f.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (25,'1520ab94-d74a-4773-bc3f-e503e9b33ec0','$2a$10$1ue6NPxybI6Zd2M2zcw60.agZwrW1SzuoBTDTpL2v6gVKIDC116M.','953b0ac1-077f-4bfa-84fd-91bfc4dee219@7abd57c1-f48a-4b40-a854-bc4b5545d022.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (26,'88ddc479-08dc-4a53-9024-6682dde82ffa','$2a$10$BcRNq29LbBxA4AxiVqKK9upuI6JDF3ekc4hQ5hHgRrPIt84XrL51O','4db79113-da26-4d82-a91f-2e0d6c3cba1f@92c0ee9e-e833-4d73-a85d-3dddb28f216c.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (27,'b2b5b4b8-fcec-4d01-a138-60205c4c56d3','$2a$10$N7eJCgbxMow5rcKKR5kXzeohLt27xJSE/e2Qf7UozAKzYvgVDLgeW','fdef00b5-c47e-426a-b24f-ac09df674424@f9664c98-7e1f-4a6e-9b5c-5503712369fc.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (28,'5cba2c5e-a8f7-46ba-a75b-72c3c1664060','$2a$10$k9AwcZw895mk2acYMJJPv.D2wucrL2GgjPL3SEmywnf8.PNwNMrB.','5ebb9507-fdb9-4efe-b07f-a959009493ac@bbe9bc90-6fc6-466c-a4e0-091900e4edb6.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (29,'d3533234-7994-4529-8fdb-14ff91d64692','$2a$10$mLlhgbVoY5XvYdFWjjeMEutXU2VLLQxLmQAY0RTBIFfR07ahTsr/y','3c218e51-6a91-4433-83af-1b42c3d81c8c@82cb7ad4-d8ab-4968-9eb8-72bc09f6dcbc.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (30,'8f58c030-48dd-4c2f-8581-7744ad485ea8','$2a$10$lpaP3jvETe9GJC83F1wgwu0Zmz1yDtVQRdCEHTwmJEbJugK/kvzYK','deee94a8-658a-4e32-973b-55f7b36a1c40@dcb4ff1c-6ff8-45a5-aea2-bb34efc6d67e.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (31,'4aa66926-fe45-4fd9-8e3f-b35f6683e423','$2a$10$r7yjgeBPPljoBBwTyL1VzOKUFyTGfEQatdTUWIyx3HW9l81fQxE5u','277a4a57-020f-4e8b-9578-a69ef66e59e2@3f228f25-d883-42f6-9246-ad31949019fa.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (32,'21bba737-42b7-445f-be96-d5c258b1f101','$2a$10$6Khv64WpJyy7YMsldcnMVOlK4fa2ExGZslSgPOqBDkWYR03Q8SkAK','86662497-7ef9-420e-a93a-892eba22dbab@adbda533-090f-469c-a3c2-98a4bfec7ddb.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (33,'7a1c2223-d0a4-4548-8450-862064442ef4','$2a$10$umbU9BjZBQV0Kz//vnQO6.lB8TO7AXL53/vprjqcws3sO81fP2yu2','f7e9e5a7-7880-4c9a-b4ac-ff8bb4d45c4d@4c800078-053c-454f-a455-bdf78d1317e1.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (34,'53156a63-2c89-4b24-888d-ae693b104adf','$2a$10$Sy9Mz0yPpQd.7.T8qzDQEuDWmGy/LfPhuoAUzPKjVXlC29QbGGTdW','b0e2512f-8aab-4830-91b2-039d4385f3c8@caa50bee-4423-4ef5-b467-16597dd5f9d0.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (35,'0c0a4849-5b13-40d8-abac-098cd9d182b4','$2a$10$GBn.emoApMyW.oyGDX.WIOmIremIG9EckSoEDG9E3cURM/HmKAm/O','713eafe1-25ae-44ab-a675-2e08da8c3004@53ead3df-fc54-44d8-8649-587dcf657bb4.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (36,'50f26f50-27a0-435d-a6ba-7cbd1c56730a','$2a$10$353iYhNz7oQD79XriWkOs.8TAjNg0XyOS1oRJeYywDiyEQfWPTKDq','53691d76-7a82-4d8b-88dc-e9858004f754@3bec520e-2d41-4d93-bb10-2e455f8ee92f.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (37,'e4c5f1b9-cb56-45e5-a0a3-91a4ee3f7d69','$2a$10$Zk17kDcKHGkTI/.gM0Wvz.Pb29.cJZzWUd0C7Cho5DnzB./9S3Wr.','b772358e-bbfe-4c6e-9b96-4d70c69a4bf8@6e625169-8f8d-430b-9ba8-5d9db999ed31.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (38,'9868720b-93d7-49af-b531-ad23b21b40c1','$2a$10$WRP.4cFhaDFcznx6ypigPe0I9wTSOJZYSmWzJ3zJXlqRg1e5Smy4S','f07974c2-f9ff-41c7-a294-96a6600acb70@e7685d53-9818-4b87-94fb-74c9ee8cf457.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (39,'5d420563-b0f2-4cf2-aeda-b15db74771f2','$2a$10$jSo8SipynAsFycNvZ5ezpOqLFSEnfHuvtXC2879cVSOndk6/KOJIW','9eb9359b-9198-43fa-9f1a-a199322f3e35@cecffd5c-7204-4ed7-bf1c-4d596ccba179.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (40,'58ea7457-c66d-467e-bf15-f86ef0635446','$2a$10$aY1ctPiW8zuo8WLNwRtoTuTAtrebCM01wiinTdwSQPyvGwY2eKxja','c4a2df4d-23a5-41c4-bc7e-da3af8dd1aaa@3795781a-c8b6-4f8a-a30d-ade371109410.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (41,'d243b547-2e09-4658-bd82-c952e63a9038','$2a$10$x0Yyh8iVOy79dA5swDbDiePL7x7RWxbJ/VYHi9JtGAsJSlBonahxa','5704c6b6-8f03-4d54-865f-407ec6821cb3@33cda0a4-524a-45d4-af47-827b7bd18c8b.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (42,'737bff10-257c-42ac-9887-42e416c6cf83','$2a$10$hOhuz1P3wpOqOgxnJjjl1.jwQqZsKMCkEuSogEiCvUgx1pxk6rbuC','f354ae17-5f87-4c15-9845-488a99fa930b@3291cbf8-f6f0-4004-847c-203b1a5e4b6d.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (43,'87fc1e1d-4303-40be-a9d6-406ac071ca8d','$2a$10$TIJtBtizk0ks8CDzM0Hjf.SSdK8VdePBRSU0AoBUyKR03M9TKnXqK','c1d36c6f-57a5-49b0-ba93-03c43c8b6169@38f34ec4-07bc-4e85-851f-3b4e984fd4d5.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (44,'409c70a1-6c68-4d5d-8c8b-af3a08bef060','$2a$10$bos7qszMC1K2rdVuV8uJUOzl9Lsy14JUfY/2JlL/VEUBPMgAXoPNe','5a6332e1-260c-41c1-81e5-ba771a774171@dd9c43f9-6a42-48fe-a67a-6e7415f2048b.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (45,'32a1bb61-6adb-4c20-b475-22e865854748','$2a$10$YPwmvMsQZzRivOoTGcl86ed9F4kec47nCtmuV0YavqovgoOWM67cm','54398383-0509-46df-ab39-232c660a6644@1357ef84-fe07-4278-9129-948a747ab61d.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (46,'6d1077e4-2b8f-4722-b6f3-3879b585f32b','$2a$10$J.mrW3tZs2U6ySkD8HwfgOH3dqTpTf80R5.cy57dXM.MTJh5QDgMO','9a7f76b5-4ab7-4bda-aa94-0c17f0acdf1d@ff618e31-9429-4fc4-b510-4b14239fc58c.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (47,'50bfcd8a-b48d-49cc-8ceb-15757b97d0c0','$2a$10$rAuJNFL1jdQ71dp3W4msA.gyMKFSVgxwzpExJ/unY/W/4hA8Znzp.','e56a9971-525d-446f-8da5-55b120e5b7a8@de276b38-3440-4d76-b6a9-162c1d437c7f.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (48,'272f146c-60c7-4297-80af-f0577569d122','$2a$10$Ly8hj/4Mqpzu2a2/MOjr..RqD3by5jK2OTdaFtipTsea4qO4vUKN6','e5bbfeba-cbbd-49d3-97b7-e2c501a94fe1@a3938d40-3a8a-4af4-858c-685a6d064ab0.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (49,'661c48cb-9d6e-4006-b335-ba478e2c6ab9','$2a$10$ek2POSJYUXRkNxv4AmcJVehaf2UPaXz.RsctBf87eXBTCMGAwHlWG','445e8692-fe1b-4e9d-86b4-5948709eee97@e3b88de6-aabf-4a7e-bcc9-93f815da63b7.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (50,'835f28f4-403b-43fd-b66b-bcf22f79b122','$2a$10$Zdeg7NIbFBr6gVZ3x8GB4uv6B49Oc1Y8mtqKfCy7XygF9IVHNa5IG','68189596-b1b3-4ba3-8eea-3c16f6146f09@555a70ee-95c2-4e68-8c8f-122c397ac733.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (51,'2ee8dcf7-d5b5-4f62-9e87-0b916fcca121','$2a$10$VKRrtE8mMCnPF83JWJW32.xMpce5hfnBvRPZmb.sqiIFCLNuXztMy','cfbbc510-d75e-4d65-b17f-3c5495161277@5647ed92-9307-42d8-9480-b1cabe33b57c.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (52,'d58926a9-4d67-49ad-822d-e222c306a5b1','$2a$10$vLlUpSzVHLc88lUeMI9bfeUlkeFiEj7h773/gjccFw5eF0g2oo1sS','6fa9ae69-decc-49d3-956a-b7c4013cfc3a@c103e951-b066-487c-9432-9ce9d5a86dd8.com',true);
INSERT INTO sys_user (user_id, username, password, email, enabled) VALUE (53,'b9b76d5a-eca2-42d4-b640-7e52b7c2326b','$2a$10$R52c/JdsH3Y2xXNMDQ.p/ep.NZZoarCXuJ4fgx3/a2H/.uaNGPEyW','417906ed-1e8e-40f6-842f-94156601ab95@e52088bd-43d4-4570-9a2b-c3cf720fe7c5.com',true);








INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (4,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (5,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (6,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (7,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (8,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (9,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (10,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (11,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (12,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (13,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (14,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (15,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (16,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (17,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (18,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (19,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (20,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (21,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (22,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (23,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (24,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (25,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (26,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (27,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (28,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (29,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (30,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (31,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (32,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (33,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (34,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (35,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (36,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (37,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (38,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (39,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (40,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (41,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (42,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (43,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (44,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (45,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (46,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (47,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (48,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (49,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (50,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (51,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (52,3);
INSERT INTO sys_user_role (from_user_id, from_role_id) VALUE (53,3);