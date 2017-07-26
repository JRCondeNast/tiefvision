import os
import argparse

def parse_arguments():
    parser = argparse.ArgumentParser()
    parser.add_argument("serving_ip_port", help="path to image folder, format /path_to_image_folder/")
    parser.add_argument("image_file_folder", help="server ip address and port, format 10.96.0.147:6006")
    args = parser.parse_args()
    return args

def process_image(serving_ip_port, image_folder_path):
    images = os.listdir(image_folder_path)
    for image in images:
        os.system(
            '/serving/bazel-bin/tensorflow_serving/example/inception_client --server=' + serving_ip_port + ' --image=' + os.path.join(
                image_folder_path, image) + '>' + ('/serving/data/' + image + '.json'))

if __name__ == '__main__':
    args = parse_arguments()
    process_image(args.serving_ip_port, args.image_file_folder)


