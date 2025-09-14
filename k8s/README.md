# Kubernetes 배포 가이드

## 자동 배포
GitHub Actions를 통해 자동으로 EKS에 배포됩니다.

## 수동 배포
```bash
# EKS 클러스터 연결
aws eks update-kubeconfig --region ap-northeast-2 --name eks-dev

# 배포
kubectl apply -f k8s/

# 상태 확인
kubectl get pods -l app=charon-blog
kubectl get service charon-blog-service
```

## 접속
LoadBalancer 서비스의 External IP로 접속:
```bash
kubectl get service charon-blog-service
```

## 리소스 정리
```bash
kubectl delete -f k8s/
```