#!bin/bash
cat ./fashion_object_detection_docker_image/frcnn_T_0.7_NMS_0.3.tar | docker import - fashion_object_detection:v1
sudo docker run fashion_object_detection:v1 --name fod_process_image -v ./generate_bounding_box:/root/generate_bounding_box -v ./data/vogue.com/:/root/data/vogue.com generate_bounding_box.sh
sudo docker exec -it fod_process-image bash
cd /serving/bazel-bin/tensorflow_serving/example
./text_to_msg